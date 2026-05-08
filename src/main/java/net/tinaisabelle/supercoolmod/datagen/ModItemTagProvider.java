package net.tinaisabelle.supercoolmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.item.ModItems;
import net.tinaisabelle.supercoolmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Items.IRON_TOOL_MATERIALS)
                .add(Items.IRON_INGOT);

        getOrCreateTagBuilder(ModTags.Items.COPPER_TOOL_MATERIALS)
                .add(Items.COPPER_INGOT);

        getOrCreateTagBuilder(ModTags.Items.GOLDEN_TOOL_MATERIALS)
                .add(Items.GOLD_INGOT);

        getOrCreateTagBuilder(ModTags.Items.DIAMOND_TOOL_MATERIALS)
                .add(Items.DIAMOND);

        getOrCreateTagBuilder(ModTags.Items.NETHERITE_TOOL_MATERIALS)
                .add(Items.NETHERITE_INGOT);

    }


}
