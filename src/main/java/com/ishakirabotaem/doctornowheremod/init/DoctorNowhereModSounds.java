
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ishakirabotaem.doctornowheremod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import com.ishakirabotaem.doctornowheremod.DoctorNowhereMod;

public class DoctorNowhereModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DoctorNowhereMod.MODID);
	public static final RegistryObject<SoundEvent> NOISE = REGISTRY.register("noise", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("doctor_nowhere", "noise")));
	public static final RegistryObject<SoundEvent> DRONE = REGISTRY.register("drone", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("doctor_nowhere", "drone")));
	public static final RegistryObject<SoundEvent> GLITCH_DRONE = REGISTRY.register("glitch_drone", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("doctor_nowhere", "glitch_drone")));
}
