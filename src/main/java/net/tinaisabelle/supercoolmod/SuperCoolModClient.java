package net.tinaisabelle.supercoolmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.entity.ModEntities;
import net.tinaisabelle.supercoolmod.entity.client.TomatoRenderer;
import net.tinaisabelle.supercoolmod.entity.custom.TomatoEntity;

public class SuperCoolModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_BUSH, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.TOMATO, TomatoRenderer::new);

    }
}
