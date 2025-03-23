package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

public class PerformMajorEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (DoctorNowhereModVariables.MapVariables.get(world).performMajorEvent == true) {
			if (DoctorNowhereModVariables.MapVariables.get(world).majorEvent == 1) {
				if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
					DoctorNowhereModVariables.MapVariables.get(world).performMajorEvent = false;
					DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
					MinorLightsOffProcedure.execute(world, x, y, z);
					MajorFollowerProcedure.execute(world, entity);
				}
			}
			if (DoctorNowhereModVariables.MapVariables.get(world).majorEvent == 2) {
				DoctorNowhereModVariables.MapVariables.get(world).performMajorEvent = false;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				if (DoctorNowhereModVariables.MapVariables.get(world).locuststage == 0) {
					MajorLocustProcedure.execute(world, entity);
				} else {
					MajorLocustEvolutionProcedure.execute(world, entity);
				}
			}
		}
	}
}
