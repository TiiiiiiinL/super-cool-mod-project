package net.tinaisabelle.supercoolmod.block.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.block.custom.RiceCropBlock;
import net.tinaisabelle.supercoolmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.RICE_CROP, RiceCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COOKED_RICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED); //tomat ska vara en buske
        itemModelGenerator.register(ModItems.RICE_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CILANTRO, Models.GENERATED); //det ska också vara en buske
    }
}
