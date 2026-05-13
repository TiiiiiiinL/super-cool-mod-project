package net.tinaisabelle.supercoolmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import net.tinaisabelle.supercoolmod.block.custom.RiceCropBlock;
import net.tinaisabelle.supercoolmod.block.custom.TomatoBushBlock;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JADE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JADE_ORE_BLOCK);
        
        blockStateModelGenerator.registerCrop(ModBlocks.RICE_CROP, RiceCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.TOMATO_BUSH,BlockStateModelGenerator.TintType.NOT_TINTED,
                TomatoBushBlock.AGE, 0, 1, 2, 3);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TEA_LEAVES, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_JADE_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUCUMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAMEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAOZI, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAKI_ROLL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MATCHA, Models.GENERATED);
        
        itemModelGenerator.register(ModItems.COOKED_RICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RICE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CILANTRO, Models.GENERATED); //det ska också vara en buske
        itemModelGenerator.register(ModItems.WOODEN_SICKLE, Models.GENERATED);

    }

}
