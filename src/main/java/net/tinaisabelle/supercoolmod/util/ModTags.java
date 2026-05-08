package net.tinaisabelle.supercoolmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SuperCoolMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> IRON_TOOL_MATERIALS = createTag("iron_tool_materials");
        public static final TagKey<Item> COPPER_TOOL_MATERIALS = createTag("copper_tool_materials");
        public static final TagKey<Item> GOLDEN_TOOL_MATERIALS = createTag("golden_tool_materials");
        public static final TagKey<Item> DIAMOND_TOOL_MATERIALS = createTag("diamond_tool_materials");
        public static final TagKey<Item> NETHERITE_TOOL_MATERIALS = createTag("netherite_tool_materials");



        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SuperCoolMod.MOD_ID, name));
        }
    }

}
