package net.tinaisabelle.supercoolmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;

public class ModItems {

    public static final Item RAW_RICE = registerItem("raw_rice", new Item(new Item.Settings()));


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
    }
}
