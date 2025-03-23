
package com.ishakirabotaem.doctornowheremod.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import com.ishakirabotaem.doctornowheremod.entity.model.TheLocustEvolutionModel;
import com.ishakirabotaem.doctornowheremod.entity.TheLocustEvolutionEntity;

public class TheLocustEvolutionRenderer extends GeoEntityRenderer<TheLocustEvolutionEntity> {
	public TheLocustEvolutionRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TheLocustEvolutionModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(TheLocustEvolutionEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, TheLocustEvolutionEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 0.15f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
