package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.GlowSquid;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BadMobsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Zombie || entity instanceof Villager || entity instanceof Drowned || entity instanceof Spider || entity instanceof EnderMan || entity instanceof Skeleton || entity instanceof TropicalFish || entity instanceof Creeper
				|| entity instanceof Bat || entity instanceof Chicken || entity instanceof Pig || entity instanceof Sheep || entity instanceof Cow || entity instanceof ZombieVillager || entity instanceof Witch || entity instanceof Donkey
				|| entity instanceof Horse || entity instanceof Fox || entity instanceof Wolf || entity instanceof Cat || entity instanceof Ocelot || entity instanceof Panda || entity instanceof Frog || entity instanceof Ghast
				|| entity instanceof Piglin || entity instanceof PiglinBrute || entity instanceof WitherSkeleton || entity instanceof Warden || entity instanceof Cod || entity instanceof ZombifiedPiglin || entity instanceof Pufferfish
				|| entity instanceof Silverfish || entity instanceof MagmaCube || entity instanceof Strider || entity instanceof Stray || entity instanceof Husk || entity instanceof Evoker || entity instanceof Hoglin || entity instanceof Salmon
				|| entity instanceof GlowSquid || entity instanceof Llama || entity instanceof Goat || entity instanceof Turtle || entity instanceof Dolphin || entity instanceof Pillager || entity instanceof Vindicator || entity instanceof Camel
				|| entity instanceof Parrot || entity instanceof Slime || entity instanceof Guardian || entity instanceof ElderGuardian || entity instanceof Squid) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
	}
}
