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
public class PerformMediumEventProcedure {
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
		if (DoctorNowhereModVariables.MapVariables.get(world).performMediumEvent == true) {
			DoctorNowhereModVariables.MapVariables.get(world).performMediumEvent = false;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			if (DoctorNowhereModVariables.MapVariables.get(world).mediumEvent == 1) {
				if (DoctorNowhereModVariables.MapVariables.get(world).locuststage == 0) {
					MediumLocustObservationProcedure.execute(world, entity);
				} else {
					MediumLocustEvolutionObservationProcedure.execute(world, entity);
				}
			}
		}
	}
}
