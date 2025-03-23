package com.ishakirabotaem.doctornowheremod.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import com.ishakirabotaem.doctornowheremod.DoctorNowhereMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DoctorNowhereModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		DoctorNowhereMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		DoctorNowhereMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			if (!event.isWasDeath()) {
				clone.incave = original.incave;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					DoctorNowhereMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					DoctorNowhereMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					DoctorNowhereMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "doctor_nowhere_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				DoctorNowhereMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "doctor_nowhere_mapvars";
		public double daycounter = 0;
		public double locuststage = 0;
		public boolean locust = false;
		public boolean follower = false;
		public double event = 0;
		public double minorEventTimer = 18181.0;
		public double mediumEventTimer = 42424.0;
		public double majorEventTimer = 55555.0;
		public double minorEvent = 0;
		public double mediumEvent = 0;
		public double majorEvent = 0;
		public boolean performMinorEvent = false;
		public boolean performMediumEvent = false;
		public boolean performMajorEvent = false;
		public boolean day = false;
		public boolean boiledone = false;
		public boolean randomtp = false;
		public boolean pork = false;
		public boolean steps = false;
		public boolean weather = false;
		public double conditionalEventTimer = 0.0;
		public double conditionalEvent = 0;
		public boolean performConditionalEvent = false;
		public boolean overlay = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			daycounter = nbt.getDouble("daycounter");
			locuststage = nbt.getDouble("locuststage");
			locust = nbt.getBoolean("locust");
			follower = nbt.getBoolean("follower");
			event = nbt.getDouble("event");
			minorEventTimer = nbt.getDouble("minorEventTimer");
			mediumEventTimer = nbt.getDouble("mediumEventTimer");
			majorEventTimer = nbt.getDouble("majorEventTimer");
			minorEvent = nbt.getDouble("minorEvent");
			mediumEvent = nbt.getDouble("mediumEvent");
			majorEvent = nbt.getDouble("majorEvent");
			performMinorEvent = nbt.getBoolean("performMinorEvent");
			performMediumEvent = nbt.getBoolean("performMediumEvent");
			performMajorEvent = nbt.getBoolean("performMajorEvent");
			day = nbt.getBoolean("day");
			boiledone = nbt.getBoolean("boiledone");
			randomtp = nbt.getBoolean("randomtp");
			pork = nbt.getBoolean("pork");
			steps = nbt.getBoolean("steps");
			weather = nbt.getBoolean("weather");
			conditionalEventTimer = nbt.getDouble("conditionalEventTimer");
			conditionalEvent = nbt.getDouble("conditionalEvent");
			performConditionalEvent = nbt.getBoolean("performConditionalEvent");
			overlay = nbt.getBoolean("overlay");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("daycounter", daycounter);
			nbt.putDouble("locuststage", locuststage);
			nbt.putBoolean("locust", locust);
			nbt.putBoolean("follower", follower);
			nbt.putDouble("event", event);
			nbt.putDouble("minorEventTimer", minorEventTimer);
			nbt.putDouble("mediumEventTimer", mediumEventTimer);
			nbt.putDouble("majorEventTimer", majorEventTimer);
			nbt.putDouble("minorEvent", minorEvent);
			nbt.putDouble("mediumEvent", mediumEvent);
			nbt.putDouble("majorEvent", majorEvent);
			nbt.putBoolean("performMinorEvent", performMinorEvent);
			nbt.putBoolean("performMediumEvent", performMediumEvent);
			nbt.putBoolean("performMajorEvent", performMajorEvent);
			nbt.putBoolean("day", day);
			nbt.putBoolean("boiledone", boiledone);
			nbt.putBoolean("randomtp", randomtp);
			nbt.putBoolean("pork", pork);
			nbt.putBoolean("steps", steps);
			nbt.putBoolean("weather", weather);
			nbt.putDouble("conditionalEventTimer", conditionalEventTimer);
			nbt.putDouble("conditionalEvent", conditionalEvent);
			nbt.putBoolean("performConditionalEvent", performConditionalEvent);
			nbt.putBoolean("overlay", overlay);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				DoctorNowhereMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("doctor_nowhere", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean incave = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				DoctorNowhereMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("incave", incave);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			incave = nbt.getBoolean("incave");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.incave = message.data.incave;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
