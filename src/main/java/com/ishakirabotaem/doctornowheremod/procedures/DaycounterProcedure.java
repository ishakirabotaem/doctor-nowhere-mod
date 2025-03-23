package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import javax.annotation.Nullable;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

@Mod.EventBusSubscriber
public class DaycounterProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		DoctorNowhereModVariables.MapVariables.get(world).daycounter = Math.floor(world.dayTime() / 24000);
		DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
	}
}
