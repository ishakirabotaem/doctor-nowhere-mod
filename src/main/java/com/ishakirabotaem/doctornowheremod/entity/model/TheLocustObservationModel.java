package com.ishakirabotaem.doctornowheremod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.ishakirabotaem.doctornowheremod.entity.TheLocustObservationEntity;

public class TheLocustObservationModel extends GeoModel<TheLocustObservationEntity> {
	@Override
	public ResourceLocation getAnimationResource(TheLocustObservationEntity entity) {
		return new ResourceLocation("doctor_nowhere", "animations/thelocust.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TheLocustObservationEntity entity) {
		return new ResourceLocation("doctor_nowhere", "geo/thelocust.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TheLocustObservationEntity entity) {
		return new ResourceLocation("doctor_nowhere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
