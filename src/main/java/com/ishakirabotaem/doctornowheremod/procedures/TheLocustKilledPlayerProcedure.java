package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

public class TheLocustKilledPlayerProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof ServerPlayer) {
			if (!sourceentity.level().isClientSide())
				sourceentity.discard();
			DoctorNowhereModVariables.MapVariables.get(world).locust = false;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
			DoctorNowhereModVariables.MapVariables.get(world).locuststage = 2;
			DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
