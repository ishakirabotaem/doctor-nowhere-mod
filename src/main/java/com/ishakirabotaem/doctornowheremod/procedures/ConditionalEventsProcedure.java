package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

@Mod.EventBusSubscriber
public class ConditionalEventsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (DoctorNowhereModVariables.MapVariables.get(world).conditionalEventTimer > 0) {
			DoctorNowhereModVariables.MapVariables.get(world).conditionalEventTimer = DoctorNowhereModVariables.MapVariables.get(world).conditionalEventTimer - 1;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
		} else {
			DoctorNowhereModVariables.MapVariables.get(world).conditionalEventTimer = Mth.nextInt(RandomSource.create(), 24000, 48000);
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			if ((entity.getCapability(DoctorNowhereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DoctorNowhereModVariables.PlayerVariables())).incave == true) {
				DoctorNowhereModVariables.MapVariables.get(world).conditionalEvent = Mth.nextInt(RandomSource.create(), 1, 5);
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			}
			DoctorNowhereModVariables.MapVariables.get(world).performConditionalEvent = true;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
