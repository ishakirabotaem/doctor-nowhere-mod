package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import java.util.Comparator;

import com.ishakirabotaem.doctornowheremod.network.DoctorNowhereModVariables;
import com.ishakirabotaem.doctornowheremod.entity.TheLocustObservationEntity;
import com.ishakirabotaem.doctornowheremod.DoctorNowhereMod;

public class TheLocustObservationOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		if (entity instanceof TheLocustObservationEntity) {
			if (!world.getEntitiesOfClass(ServerPlayer.class,
					AABB.ofSize(
							new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							200, 200, 200),
					e -> true).isEmpty()) {
				player = (Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(
						new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
						200, 200, 200), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
						.findFirst().orElse(null);
				if (!(player == null)) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((player.getX()), (player.getY()), (player.getZ())));
				}
			}
			if (!world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
				DoctorNowhereModVariables.MapVariables.get(world).overlay = true;
				DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				if (entity instanceof TheLocustObservationEntity) {
					((TheLocustObservationEntity) entity).setAnimation("escape");
				}
				DoctorNowhereMod.queueServerWork(30, () -> {
					DoctorNowhereModVariables.MapVariables.get(world).overlay = false;
					DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
					if (!entity.level().isClientSide())
						entity.discard();
					DoctorNowhereModVariables.MapVariables.get(world).locust = false;
					DoctorNowhereModVariables.MapVariables.get(world).syncData(world);
				});
			}
		}
	}
}
