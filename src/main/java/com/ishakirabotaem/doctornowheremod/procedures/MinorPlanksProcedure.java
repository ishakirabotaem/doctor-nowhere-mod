package com.ishakirabotaem.doctornowheremod.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class MinorPlanksProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		x = entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40);
		z = entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40);
		y = 320;
		while (world.isEmptyBlock(BlockPos.containing(x, y, z))) {
			y = y - 1;
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 1, z);
			BlockState _bs = Blocks.OAK_PLANKS.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 2, z);
			BlockState _bs = Blocks.OAK_PLANKS.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 3, z);
			BlockState _bs = Blocks.OAK_PLANKS.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
		{
			BlockPos _bp = BlockPos.containing(x, y + 4, z);
			BlockState _bs = Blocks.OAK_PLANKS.defaultBlockState();
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
				if (_property != null && _bs.getValue(_property) != null)
					try {
						_bs = _bs.setValue(_property, (Comparable) entry.getValue());
					} catch (Exception e) {
					}
			}
			world.setBlock(_bp, _bs, 3);
		}
	}
}
