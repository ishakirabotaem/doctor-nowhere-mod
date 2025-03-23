package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class MinorRandomTeleportationProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		x = entity.getX() + Mth.nextInt(RandomSource.create(), -80, 80);
		z = entity.getZ() + Mth.nextInt(RandomSource.create(), -80, 80);
		y = 320;
		while (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			y = y - 1;
		}
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y + 1), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}
