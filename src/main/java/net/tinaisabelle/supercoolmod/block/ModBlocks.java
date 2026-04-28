package net.tinaisabelle.supercoolmod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;
import net.tinaisabelle.supercoolmod.block.custom.RiceCropBlock;
import net.tinaisabelle.supercoolmod.block.custom.TomatoBushBlock;

public class ModBlocks {
    //temp för block, kolla #3 från 4.40m
    //public static final Block RAW_RICE_BLOCK = registerBlock("raw_rice_block",
        //new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));

    public static final Block RICE_CROP = registerBlockWithOutBlockItem("rice_crop",
            new RiceCropBlock(AbstractBlock.Settings.create().
                    noCollision().
                    mapColor(MapColor.DARK_GREEN).
                    ticksRandomly().
                    breakInstantly().
                    sounds(BlockSoundGroup.CROP).
                    pistonBehavior(PistonBehavior.DESTROY)
            )
    );


    public static final Block TOMATO_BUSH = registerBlockWithOutBlockItem("tomato_bush",
            new TomatoBushBlock(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)
            )
    );


    private static Block registerBlockWithOutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(SuperCoolMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SuperCoolMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SuperCoolMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    /** Initisalise block
     * inte använd än
     */
    public static void registerModBlocks() {
        SuperCoolMod.LOGGER.info("Registering ModBlocks");
    }
}
