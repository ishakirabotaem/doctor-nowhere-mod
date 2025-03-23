package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

import java.util.Comparator;

import com.ishakirabotaem.doctornowheremod.entity.FollowerEntity;

@Mod.EventBusSubscriber
public class FollowerOnEntityTickUpdateProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FollowerEntity) {
			if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 255, 1, false, false));
			if (!world.getEntitiesOfClass(Boat.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
				if (!((Entity) world.getEntitiesOfClass(Boat.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
					((Entity) world.getEntitiesOfClass(Boat.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
			}
			if (!world.getEntitiesOfClass(ChestBoat.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
				if (!((Entity) world.getEntitiesOfClass(ChestBoat.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
					((Entity) world.getEntitiesOfClass(ChestBoat.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
			}
			if (!world.getEntitiesOfClass(IronGolem.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
				if (!((Entity) world.getEntitiesOfClass(IronGolem.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
					((Entity) world.getEntitiesOfClass(IronGolem.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
			}
			if (!world.getEntitiesOfClass(SnowGolem.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
				if (!((Entity) world.getEntitiesOfClass(SnowGolem.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
					((Entity) world.getEntitiesOfClass(SnowGolem.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
			}
			if (!world.getEntitiesOfClass(Warden.class, AABB.ofSize(new Vec3(x, y, z), 20, 20, 20), e -> true).isEmpty()) {
				if (!((Entity) world.getEntitiesOfClass(Warden.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
					((Entity) world.getEntitiesOfClass(Warden.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
			}
		}
	}
}
