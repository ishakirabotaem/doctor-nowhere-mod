
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ishakirabotaem.doctornowheremod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import com.ishakirabotaem.doctornowheremod.DoctorNowhereMod;

public class DoctorNowhereModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DoctorNowhereMod.MODID);
	public static final RegistryObject<Item> THE_LOCUST_OBSERVATION_SPAWN_EGG = REGISTRY.register("the_locust_observation_spawn_egg", () -> new ForgeSpawnEggItem(DoctorNowhereModEntities.THE_LOCUST_OBSERVATION, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> THE_LOCUST_SPAWN_EGG = REGISTRY.register("the_locust_spawn_egg", () -> new ForgeSpawnEggItem(DoctorNowhereModEntities.THE_LOCUST, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> THE_LOCUST_EVOLUTION_SPAWN_EGG = REGISTRY.register("the_locust_evolution_spawn_egg", () -> new ForgeSpawnEggItem(DoctorNowhereModEntities.THE_LOCUST_EVOLUTION, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> THE_LOCUST_EVOLUTION_OBSERVATION_SPAWN_EGG = REGISTRY.register("the_locust_evolution_observation_spawn_egg",
			() -> new ForgeSpawnEggItem(DoctorNowhereModEntities.THE_LOCUST_EVOLUTION_OBSERVATION, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> FOLLOWER_SPAWN_EGG = REGISTRY.register("follower_spawn_egg", () -> new ForgeSpawnEggItem(DoctorNowhereModEntities.FOLLOWER, -1, -1, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
