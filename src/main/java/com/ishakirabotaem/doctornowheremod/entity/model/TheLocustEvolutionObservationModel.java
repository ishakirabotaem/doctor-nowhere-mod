package com.ishakirabotaem.doctornowheremod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.ishakirabotaem.doctornowheremod.entity.TheLocustEvolutionObservationEntity;

public class TheLocustEvolutionObservationModel extends GeoModel<TheLocustEvolutionObservationEntity> {
	@Override
	public ResourceLocation getAnimationResource(TheLocustEvolutionObservationEntity entity) {
		return new ResourceLocation("doctor_nowhere", "animations/thelocustevolution.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TheLocustEvolutionObservationEntity entity) {
		return new ResourceLocation("doctor_nowhere", "geo/thelocustevolution.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TheLocustEvolutionObservationEntity entity) {
		return new ResourceLocation("doctor_nowhere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
