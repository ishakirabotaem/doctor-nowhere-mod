package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MinorSignProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		x = entity.getX() + Mth.nextInt(RandomSource.create(), -20, 20);
		z = entity.getZ() + Mth.nextInt(RandomSource.create(), -20, 20);
		y = 320;
		while (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			y = y - 1;
		}
		if (Mth.nextInt(RandomSource.create(), 0, 2) == 0) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ oak_sign{front_text:{messages:['{\"text\":\"\"}','\"starving.help\"','{\"text\":\"\"}','{\"text\":\"\"}']}}");
		} else if (Mth.nextInt(RandomSource.create(), 0, 2) == 1) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ oak_sign{front_text:{messages:['{\"text\":\"\"}','\"im hungry\"','{\"text\":\"\"}','{\"text\":\"\"}']}} replace");
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"setblock ~ ~ ~ oak_sign{front_text:{messages:['{\"text\":\"\"}','\"hello\"','{\"text\":\"\"}','{\"text\":\"\"}']}}");
		}
	}
}
