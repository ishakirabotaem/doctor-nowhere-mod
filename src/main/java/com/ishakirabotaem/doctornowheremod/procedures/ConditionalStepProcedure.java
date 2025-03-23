package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ConditionalStepProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -5, 5), y, z + Mth.nextInt(RandomSource.create(), -5, 5)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")),
						SoundSource.MASTER, 1, 1);
			} else {
				_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -5, 5)), y, (z + Mth.nextInt(RandomSource.create(), -5, 5)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.MASTER, 1, 1,
						false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -5, 5), y, z + Mth.nextInt(RandomSource.create(), -5, 5)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")),
						SoundSource.MASTER, 1, 1);
			} else {
				_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -5, 5)), y, (z + Mth.nextInt(RandomSource.create(), -5, 5)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.MASTER, 1, 1,
						false);
			}
		}
	}
}
