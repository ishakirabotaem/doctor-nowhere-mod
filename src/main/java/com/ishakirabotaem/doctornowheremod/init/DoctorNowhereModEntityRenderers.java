
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ishakirabotaem.doctornowheremod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.ishakirabotaem.doctornowheremod.client.renderer.TheLocustRenderer;
import com.ishakirabotaem.doctornowheremod.client.renderer.TheLocustObservationRenderer;
import com.ishakirabotaem.doctornowheremod.client.renderer.TheLocustEvolutionRenderer;
import com.ishakirabotaem.doctornowheremod.client.renderer.TheLocustEvolutionObservationRenderer;
import com.ishakirabotaem.doctornowheremod.client.renderer.FollowerRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DoctorNowhereModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(DoctorNowhereModEntities.THE_LOCUST_OBSERVATION.get(), TheLocustObservationRenderer::new);
		event.registerEntityRenderer(DoctorNowhereModEntities.THE_LOCUST.get(), TheLocustRenderer::new);
		event.registerEntityRenderer(DoctorNowhereModEntities.THE_LOCUST_EVOLUTION.get(), TheLocustEvolutionRenderer::new);
		event.registerEntityRenderer(DoctorNowhereModEntities.THE_LOCUST_EVOLUTION_OBSERVATION.get(), TheLocustEvolutionObservationRenderer::new);
		event.registerEntityRenderer(DoctorNowhereModEntities.FOLLOWER.get(), FollowerRenderer::new);
	}
}
