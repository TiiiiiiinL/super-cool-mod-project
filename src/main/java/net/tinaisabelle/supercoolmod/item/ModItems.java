package net.tinaisabelle.supercoolmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.item.custom.SickleItem;
import net.tinaisabelle.supercoolmod.item.custom.TomatoItem;

public class ModItems {

    public static final Item TEA_LEAVES = registerItem("tea_leaves", new Item(new Item.Settings()));


    public static final Item RAW_JADE_ORE = registerItem("raw_jade_ore", new Item(new Item.Settings()));
    public static final Item JADE_ORE = registerItem("jade_ore", new Item(new Item.Settings()));

    public static final Item CUCUMBER = registerItem("cucumber", new Item(new Item.Settings().food(ModFoodComponents.CUCUMBER)));
    public static final Item RAMEN = registerItem("ramen", new Item(new Item.Settings().food(ModFoodComponents.RAMEN)));
    public static final Item BAOZI = registerItem("baozi", new Item(new Item.Settings().food(ModFoodComponents.BAOZI)));
    public static final Item MAKI_ROLL = registerItem("maki_roll", new Item(new Item.Settings().food(ModFoodComponents.MAKI_ROLL)));
    public static final Item MATCHA = registerItem("matcha", new Item(new Item.Settings().food(ModFoodComponents.MATCHA)));
    
    public static final Item RAW_RICE = registerItem("raw_rice",
            new Item(new Item.Settings()));

    public static final Item COOKED_RICE = registerItem("cooked_rice",
            new Item(new Item.Settings().food(ModFoodComponents.COOKED_RICE)));

    public static final Item CILANTRO = registerItem("cilantro",
            new Item(new Item.Settings().food(ModFoodComponents.CILANTRO)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_BUSH, new Item.Settings()));

    public static final Item RICE_SEEDS = registerItem("rice_seeds",
            new AliasedBlockItem(ModBlocks.RICE_CROP, new Item.Settings()));

    public static final Item WOODEN_SICKLE = registerItem("wooden_sickle",
            new SickleItem(new Item.Settings().maxDamage(32))); //maxdamage==gånger kan användas

    public static final Item STONE_SICKLE = registerItem("stone_sickle",
            new SickleItem(new Item.Settings().maxDamage(65)));

    public static final Item COPPER_SICKLE = registerItem("copper_sickle",
            new SickleItem(new Item.Settings().maxDamage(130)));

    public static final Item IRON_SICKLE = registerItem("iron_sickle",
            new SickleItem(new Item.Settings().maxDamage(250)));

    public static final Item GOLDEN_SICKLE = registerItem("golden_sickle",
            new SickleItem(new Item.Settings().maxDamage(33)));

    public static final Item DIAMOND_SICKLE = registerItem("diamond_sickle",
            new SickleItem(new Item.Settings().maxDamage(1600)));

    public static final Item NETHERITE_SICKLE = registerItem("netherite_sickle",
            new SickleItem(new Item.Settings().maxDamage(2100)));

    public static final Item TOMATO = registerItem("tomato",
            new TomatoItem(new Item.Settings().food(ModFoodComponents.TOMATO)));

    /** det här e en helper metod för att registrera items
     * @param name på item
     * @param item att den e en item ig
     * @return en item
     */
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SuperCoolMod.MOD_ID, name), item);
    }

    /** det här är en register metod
     */
    public static void registerModItems() {
        SuperCoolMod.LOGGER.info("Registering ModItems");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(TEA_LEAVES);
            fabricItemGroupEntries.add(RAW_JADE_ORE);
            fabricItemGroupEntries.add(JADE_ORE);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(TOMATO);
            fabricItemGroupEntries.add(COOKED_RICE);
            fabricItemGroupEntries.add(CUCUMBER);
            fabricItemGroupEntries.add(RAMEN);
            fabricItemGroupEntries.add(BAOZI);
            fabricItemGroupEntries.add(MAKI_ROLL);
            fabricItemGroupEntries.add(MATCHA);
            fabricItemGroupEntries.add(RAW_RICE);
            fabricItemGroupEntries.add(RICE_SEEDS);
            fabricItemGroupEntries.add(CILANTRO);
            fabricItemGroupEntries.add(TOMATO_SEEDS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(WOODEN_SICKLE);
            fabricItemGroupEntries.add(STONE_SICKLE);
            fabricItemGroupEntries.add(COPPER_SICKLE);
            fabricItemGroupEntries.add(IRON_SICKLE);
            fabricItemGroupEntries.add(GOLDEN_SICKLE);
            fabricItemGroupEntries.add(DIAMOND_SICKLE);
            fabricItemGroupEntries.add(NETHERITE_SICKLE);
        });
    }
}
