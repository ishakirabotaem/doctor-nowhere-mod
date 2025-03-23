package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;

public class MinorPorkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
