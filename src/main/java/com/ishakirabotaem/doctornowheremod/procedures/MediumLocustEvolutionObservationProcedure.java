package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;
import com.ishakirabotaem.doctornowheremod.init.DoctorNowhereModEntities;
import com.ishakirabotaem.doctornowheremod.entity.TheLocustEvolutionObservationEntity;
import com.ishakirabotaem.doctornowheremod.DoctorNowhereMod;

public class MediumLocustEvolutionObservationProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		double random = 0;
		if (DoctorNowhereModVariables.MapVariables.get(world).locuststage == 2) {
			if (DoctorNowhereModVariables.MapVariables.get(world).locust == false) {
				random = Mth.nextInt(RandomSource.create(), 0, 1);
				if (random == 0) {
					x = entity.getX() + Mth.nextDouble(RandomSource.create(), -40, -80);
				} else {
					x = entity.getX() + Mth.nextDouble(RandomSource.create(), 40, 80);
				}
				y = 320;
				random = Mth.nextInt(RandomSource.create(), 0, 1);
				if (random == 0) {
					z = entity.getZ() + Mth.nextDouble(RandomSource.create(), -40, -80);
				} else {
					z = entity.getZ() + Mth.nextDouble(RandomSource.create(), 40, 80);
				}
				while (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
					y = y - 1;
				}
				DoctorNowhereModVariables.MapVariables.get(world).locust = true;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				if (world instanceof ServerLevel _serverLevel) {
					Entity entityinstance = DoctorNowhereModEntities.THE_LOCUST_EVOLUTION_OBSERVATION.get().create(_serverLevel, null, null, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED, false, false);
					if (entityinstance != null) {
						entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
						DoctorNowhereMod.queueServerWork(6000, () -> {
							if (entityinstance instanceof TheLocustEvolutionObservationEntity) {
								DoctorNowhereModVariables.MapVariables.get(world).locust = false;
								DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
								if (!entityinstance.level().isClientSide())
									entityinstance.discard();
							}
						});
						_serverLevel.addFreshEntity(entityinstance);
					}
				}
			}
		}
	}
}
