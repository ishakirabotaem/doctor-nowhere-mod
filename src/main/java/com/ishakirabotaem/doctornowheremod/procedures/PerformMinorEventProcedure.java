package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

@Mod.EventBusSubscriber
public class PerformMinorEventProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent == true) {
			DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 1) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorLightsOffProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 2) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				if (DoctorNowhereModVariables.MapVariables.get(world).steps == false) {
					MinorStepsProcedure.execute(world, x, y, z);
					DoctorNowhereModVariables.MapVariables.get(world).steps = true;
					DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 3) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorNoiseProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 4) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorLossOfHealthProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 5) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				if (DoctorNowhereModVariables.MapVariables.get(world).weather == false) {
					MinorWeatherChangeProcedure.execute(world, x, y, z);
					DoctorNowhereModVariables.MapVariables.get(world).weather = true;
					DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 6) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorStopsoundProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 7) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorDroneProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 8) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				if (DoctorNowhereModVariables.MapVariables.get(world).pork == false) {
					MinorPorkProcedure.execute(world, x, y, z);
					DoctorNowhereModVariables.MapVariables.get(world).pork = true;
					DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 9) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorArmorStandProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 10) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				if (DoctorNowhereModVariables.MapVariables.get(world).randomtp == false) {
					MinorRandomTeleportationProcedure.execute(world, entity);
					DoctorNowhereModVariables.MapVariables.get(world).randomtp = true;
					DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				}
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 11) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorSignProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 12) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorFireProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 13) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorChestProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 14) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorLightsOffProcedure.execute(world, x, y, z);
				MinorTorchesProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 15) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorPlanksProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 16) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorFurnaceProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 17) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorWorkbenchProcedure.execute(world, entity);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 18) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorPigSoundProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).minorEvent == 19) {
				DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				MinorTorchProcedure.execute(world, entity);
			}
		}
	}
}
