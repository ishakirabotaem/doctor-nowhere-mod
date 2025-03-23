package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.LevelAccessor;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;

public class ScreenDisplayOverlayIngameProcedure {
	public static boolean execute(LevelAccessor world) {
		if (DoctorNowhereModVariables.MapVariables.get(world).overlay == true) {
			return true;
		}
		return false;
	}
}
