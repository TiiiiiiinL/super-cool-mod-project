package net.tinaisabelle.supercoolmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;

public class ModBlocks {
    //temp för block, kolla #3 från 4.40m
    //public static final Block RAW_RICE_BLOCK = registerBlock("raw_rice_block",
            //new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));

    public static final Block JADE_BLOCK = registerBlock("jade_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block JADE_ORE_BLOCK= registerBlock("jade_ore_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SuperCoolMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SuperCoolMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    /** Initisalise block
     * venne om behövs
     */
    public static void registerModBlocks() {
        SuperCoolMod.LOGGER.info("Registering ModBlocks" + SuperCoolMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.JADE_BLOCK);
            entries.add(ModBlocks.JADE_ORE_BLOCK);
        });
    }
}
