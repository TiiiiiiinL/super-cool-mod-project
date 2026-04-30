package net.tinaisabelle.supercoolmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider{

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.JADE_BLOCK);
        addDrop(ModBlocks.JADE_ORE_BLOCK, oreDrops(ModBlocks.JADE_ORE_BLOCK, ModItems.RAW_JADE_ORE));
    }
}
