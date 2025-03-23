package com.ishakirabotaem.doctornowheremod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.ishakirabotaem.doctornowheremod.entity.TheLocustEntity;

public class TheLocustModel extends GeoModel<TheLocustEntity> {
	@Override
	public ResourceLocation getAnimationResource(TheLocustEntity entity) {
		return new ResourceLocation("doctor_nowhere", "animations/thelocust.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TheLocustEntity entity) {
		return new ResourceLocation("doctor_nowhere", "geo/thelocust.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TheLocustEntity entity) {
		return new ResourceLocation("doctor_nowhere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
