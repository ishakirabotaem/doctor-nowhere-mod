
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ishakirabotaem.doctornowheremod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import com.ishakirabotaem.doctornowheremod.entity.TheLocustObservationEntity;
import com.ishakirabotaem.doctornowheremod.entity.TheLocustEvolutionObservationEntity;
import com.ishakirabotaem.doctornowheremod.entity.TheLocustEvolutionEntity;
import com.ishakirabotaem.doctornowheremod.entity.TheLocustEntity;
import com.ishakirabotaem.doctornowheremod.entity.FollowerEntity;
import com.ishakirabotaem.doctornowheremod.DoctorNowhereMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DoctorNowhereModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DoctorNowhereMod.MODID);
	public static final RegistryObject<EntityType<TheLocustObservationEntity>> THE_LOCUST_OBSERVATION = register("the_locust_observation", EntityType.Builder.<TheLocustObservationEntity>of(TheLocustObservationEntity::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TheLocustObservationEntity::new).fireImmune().sized(0.6f, 3f));
	public static final RegistryObject<EntityType<TheLocustEntity>> THE_LOCUST = register("the_locust",
			EntityType.Builder.<TheLocustEntity>of(TheLocustEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(200).setUpdateInterval(3).setCustomClientFactory(TheLocustEntity::new).fireImmune().sized(0.8f, 8f));
	public static final RegistryObject<EntityType<TheLocustEvolutionEntity>> THE_LOCUST_EVOLUTION = register("the_locust_evolution", EntityType.Builder.<TheLocustEvolutionEntity>of(TheLocustEvolutionEntity::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(200).setUpdateInterval(3).setCustomClientFactory(TheLocustEvolutionEntity::new).fireImmune().sized(0.8f, 11f));
	public static final RegistryObject<EntityType<TheLocustEvolutionObservationEntity>> THE_LOCUST_EVOLUTION_OBSERVATION = register("the_locust_evolution_observation",
			EntityType.Builder.<TheLocustEvolutionObservationEntity>of(TheLocustEvolutionObservationEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(200).setUpdateInterval(3)
					.setCustomClientFactory(TheLocustEvolutionObservationEntity::new).fireImmune().sized(0.8f, 11f));
	public static final RegistryObject<EntityType<FollowerEntity>> FOLLOWER = register("follower",
			EntityType.Builder.<FollowerEntity>of(FollowerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(200).setUpdateInterval(3).setCustomClientFactory(FollowerEntity::new).fireImmune().sized(0.8f, 7.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TheLocustObservationEntity.init();
			TheLocustEntity.init();
			TheLocustEvolutionEntity.init();
			TheLocustEvolutionObservationEntity.init();
			FollowerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(THE_LOCUST_OBSERVATION.get(), TheLocustObservationEntity.createAttributes().build());
		event.put(THE_LOCUST.get(), TheLocustEntity.createAttributes().build());
		event.put(THE_LOCUST_EVOLUTION.get(), TheLocustEvolutionEntity.createAttributes().build());
		event.put(THE_LOCUST_EVOLUTION_OBSERVATION.get(), TheLocustEvolutionObservationEntity.createAttributes().build());
		event.put(FOLLOWER.get(), FollowerEntity.createAttributes().build());
	}
}
