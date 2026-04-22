package net.tinaisabelle.supercoolmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;

public class ModItems {

    //man lowkey ska lägga de som e food på en annan, för den e inte bara items o så men det är iaf test grej, ändrar mer sen när jag kommer dit
    public static final Item RAW_RICE = registerItem("raw_rice", new Item(new Item.Settings()));

    public static final Item COOKED_RICE = registerItem("cooked_rice", new Item(new Item.Settings().food(ModFoodComponents.COOKED_RICE)));
    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings().food(ModFoodComponents.TOMATO)));

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
            fabricItemGroupEntries.add(RAW_RICE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(TOMATO);
            fabricItemGroupEntries.add(COOKED_RICE);

        });
    }
}
