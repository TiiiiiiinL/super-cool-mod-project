package net.tinaisabelle.supercoolmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.block.custom.RiceCropBlock;
import net.tinaisabelle.supercoolmod.block.custom.TomatoBushBlock;
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
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        //addDrop(ModBlocks.NAME);
        //ores lite olika

        /*
        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(RiceCropBlock.AGE,RiceCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.RICE_CROP, this.cropDrops(ModBlocks.RICE_CROP, ModItems.RAW_RICE, ModItems.RICE_SEEDS, builder2));
        */

        this.addDrop(ModBlocks.RICE_CROP, LootTable.builder()
        //full med
        .pool(LootPool.builder()
            .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
                .properties(StatePredicate.Builder.create()
                    .exactMatch(RiceCropBlock.AGE, RiceCropBlock.MAX_AGE)))
            .conditionally(MatchToolLootCondition.builder(
                ItemPredicate.Builder.create().items(ModItems.WOODEN_SICKLE)))//göra mod tag så den funkar för alla sickle
            .with(ItemEntry.builder(ModItems.RAW_RICE))
            .apply(SetCountLootFunction.builder(
                UniformLootNumberProvider.create(4.0F, 6.0F)))
        )

        // full utan sickle
        .pool(LootPool.builder()
            .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
                .properties(StatePredicate.Builder.create()
                    .exactMatch(RiceCropBlock.AGE, RiceCropBlock.MAX_AGE)))
                .conditionally(InvertedLootCondition.builder(
                        MatchToolLootCondition.builder(
                                ItemPredicate.Builder.create().items(ModItems.WOODEN_SICKLE)
                        )
                ).build())
            .with(ItemEntry.builder(ModItems.RAW_RICE))
            .apply(SetCountLootFunction.builder(
                UniformLootNumberProvider.create(1.0F, 3.0F)))
        )

        //seeds alltid droppa
        .pool(LootPool.builder()
            .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
                .properties(StatePredicate.Builder.create()
                    .exactMatch(RiceCropBlock.AGE, RiceCropBlock.MAX_AGE)))
            .with(ItemEntry.builder(ModItems.RICE_SEEDS))
            .apply(SetCountLootFunction.builder(
                UniformLootNumberProvider.create(1.0F, 2.0F)))
        )

        // inte full
        .pool(LootPool.builder()
            .conditionally(InvertedLootCondition.builder(
                    BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP)
                .properties(StatePredicate.Builder.create()
                    .exactMatch(RiceCropBlock.AGE, RiceCropBlock.MAX_AGE))).build())
            .with(ItemEntry.builder(ModItems.RICE_SEEDS))
            .apply(SetCountLootFunction.builder(
                UniformLootNumberProvider.create(1.0F, 2.0F)))
        )
    );




        this.addDrop(ModBlocks.TOMATO_BUSH,
                block -> this.applyExplosionDecay(
                        block, LootTable.builder()
                .pool(LootPool.builder()
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_BUSH)
                                .properties(StatePredicate.Builder.create()
                                        .exactMatch(TomatoBushBlock.AGE, 3)))
                        .with(ItemEntry.builder(ModItems.TOMATO))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                ) //inte full
                .pool(LootPool.builder()
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_BUSH)
                                .properties(StatePredicate.Builder.create().exactMatch(TomatoBushBlock.AGE, 2)))
                        .with(ItemEntry.builder(ModItems.TOMATO))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));


    }
}
