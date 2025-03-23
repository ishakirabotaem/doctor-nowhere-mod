package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

@Mod.EventBusSubscriber
public class PerformConditionalEventProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (DoctorNowhereModVariables.MapVariables.get(world).performConditionalEvent == true) {
			DoctorNowhereModVariables.MapVariables.get(world).performConditionalEvent = false;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			if (DoctorNowhereModVariables.MapVariables.get(world).conditionalEvent == 1) {
				ConditionalNoTorchesProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).conditionalEvent == 2) {
				ConditionalGlitchDroneProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).conditionalEvent == 3) {
				ConditionalStepProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).conditionalEvent == 4) {
				ConditionalNoiseProcedure.execute(world, x, y, z);
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).conditionalEvent == 5) {
				ConditionalNoiseProcedure.execute(world, x, y, z);
			}
		}
	}
}
