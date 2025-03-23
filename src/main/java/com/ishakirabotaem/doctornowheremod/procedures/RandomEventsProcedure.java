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
public class RandomEventsProcedure {
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
		if (DoctorNowhereModVariables.MapVariables.get(world).minorEventTimer > 0) {
			if ((entity.getCapability(DoctorNowhereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DoctorNowhereModVariables.PlayerVariables())).incave == false) {
				DoctorNowhereModVariables.MapVariables.get(world).minorEventTimer = DoctorNowhereModVariables.MapVariables.get(world).minorEventTimer - 1;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			DoctorNowhereModVariables.MapVariables.get(world).minorEventTimer = Mth.nextInt(RandomSource.create(), 24000, 64000);
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			DoctorNowhereModVariables.MapVariables.get(world).minorEvent = Mth.nextInt(RandomSource.create(), 1, 19);
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			DoctorNowhereModVariables.MapVariables.get(world).performMinorEvent = true;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
		}
		if (DoctorNowhereModVariables.MapVariables.get(world).mediumEventTimer > 0) {
			if ((entity.getCapability(DoctorNowhereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DoctorNowhereModVariables.PlayerVariables())).incave == false) {
				DoctorNowhereModVariables.MapVariables.get(world).mediumEventTimer = DoctorNowhereModVariables.MapVariables.get(world).mediumEventTimer - 1;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			DoctorNowhereModVariables.MapVariables.get(world).mediumEventTimer = Mth.nextInt(RandomSource.create(), 48000, 64000);
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			DoctorNowhereModVariables.MapVariables.get(world).mediumEvent = Mth.nextInt(RandomSource.create(), 1, 1);
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			DoctorNowhereModVariables.MapVariables.get(world).performMediumEvent = true;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
		}
		if (DoctorNowhereModVariables.MapVariables.get(world).majorEventTimer > 0) {
			if ((entity.getCapability(DoctorNowhereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new DoctorNowhereModVariables.PlayerVariables())).incave == false) {
				DoctorNowhereModVariables.MapVariables.get(world).majorEventTimer = DoctorNowhereModVariables.MapVariables.get(world).majorEventTimer - 1;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			DoctorNowhereModVariables.MapVariables.get(world).majorEventTimer = Mth.nextInt(RandomSource.create(), 72000, 144000);
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			DoctorNowhereModVariables.MapVariables.get(world).majorEvent = Mth.nextInt(RandomSource.create(), 1, 2);
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			DoctorNowhereModVariables.MapVariables.get(world).performMajorEvent = true;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
