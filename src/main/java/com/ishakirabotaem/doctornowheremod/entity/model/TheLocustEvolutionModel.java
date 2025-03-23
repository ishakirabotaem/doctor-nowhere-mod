package com.ishakirabotaem.doctornowheremod.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import com.ishakirabotaem.doctornowheremod.entity.TheLocustEvolutionEntity;

public class TheLocustEvolutionModel extends GeoModel<TheLocustEvolutionEntity> {
	@Override
	public ResourceLocation getAnimationResource(TheLocustEvolutionEntity entity) {
		return new ResourceLocation("doctor_nowhere", "animations/thelocustevolution.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TheLocustEvolutionEntity entity) {
		return new ResourceLocation("doctor_nowhere", "geo/thelocustevolution.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TheLocustEvolutionEntity entity) {
		return new ResourceLocation("doctor_nowhere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
