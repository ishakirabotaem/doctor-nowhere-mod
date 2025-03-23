package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class MinorArmorStandProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		x = entity.getX() + Mth.nextInt(RandomSource.create(), -20, 20);
		z = entity.getZ() + Mth.nextInt(RandomSource.create(), -20, 20);
		y = 320;
		while (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			y = y - 1;
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = EntityType.ARMOR_STAND.spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
	}
}
