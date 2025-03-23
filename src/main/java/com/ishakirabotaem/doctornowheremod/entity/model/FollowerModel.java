package com.ishakirabotaem.doctornowheremod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.ishakirabotaem.doctornowheremod.entity.FollowerEntity;

public class FollowerModel extends GeoModel<FollowerEntity> {
	@Override
	public ResourceLocation getAnimationResource(FollowerEntity entity) {
		return new ResourceLocation("doctor_nowhere", "animations/follower.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FollowerEntity entity) {
		return new ResourceLocation("doctor_nowhere", "geo/follower.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FollowerEntity entity) {
		return new ResourceLocation("doctor_nowhere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
