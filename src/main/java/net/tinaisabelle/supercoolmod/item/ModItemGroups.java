package net.tinaisabelle.supercoolmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;
import net.tinaisabelle.supercoolmod.block.ModBlocks;

public class ModItemGroups {

    //Koppiera hela blocket nedan och klistra in under för att skapa nya flikar.
    //Ändra namn och ikon och sen vilka items som är i och sådär :):)
    public static final ItemGroup NEW_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SuperCoolMod.MOD_ID, "new_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RAMEN))
                    .displayName(Text.translatable("itemgroup.super-cool-mod.new_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAMEN);
                        entries.add(ModItems.BAOZI);
                        entries.add(ModItems.MAKI_ROLL);
                        entries.add(ModItems.TEA_LEAVES);
                        entries.add(ModItems.TEA_LEAVES_SEEDS);
                        entries.add(ModItems.CUCUMBER);
                        entries.add(ModItems.MATCHA);
                        entries.add(ModItems.JADE_ORE);
                        entries.add(ModItems.RAW_JADE_ORE);
                        entries.add(ModBlocks.JADE_BLOCK);
                        entries.add(ModBlocks.JADE_ORE_BLOCK);
                    }).build());



    public static void registerItemGroups(){
        SuperCoolMod.LOGGER.info("Registering Item Groups for " + SuperCoolMod.MOD_ID);
    }
}
