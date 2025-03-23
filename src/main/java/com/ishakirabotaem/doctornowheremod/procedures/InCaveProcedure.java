package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

@Mod.EventBusSubscriber
public class InCaveProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getY() < 50) {
			{
				boolean _setval = true;
				entity.getCapability(DoctorNowhereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.incave = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(DoctorNowhereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.incave = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
