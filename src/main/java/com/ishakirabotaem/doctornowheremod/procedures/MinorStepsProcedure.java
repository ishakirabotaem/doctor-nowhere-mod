package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import com.ishakirabotaem.doctornowheremod.DoctorNowhereMod;

public class MinorStepsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		new Object() {
			void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -5, 5), y, z + Mth.nextInt(RandomSource.create(), -5, 5)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")),
								SoundSource.MASTER, 1, 1);
					} else {
						_level.playLocalSound((x + Mth.nextInt(RandomSource.create(), -5, 5)), y, (z + Mth.nextInt(RandomSource.create(), -5, 5)), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.MASTER, 1,
								1, false);
					}
				}
				final int tick2 = ticks;
				DoctorNowhereMod.queueServerWork(tick2, () -> {
					if (timedlooptotal > timedloopiterator + 1) {
						timedLoop(timedloopiterator + 1, timedlooptotal, tick2);
					}
				});
			}
		}.timedLoop(0, 6, 6);
	}
}
