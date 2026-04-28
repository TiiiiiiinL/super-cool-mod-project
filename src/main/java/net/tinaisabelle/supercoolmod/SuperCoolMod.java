package net.tinaisabelle.supercoolmod;

import net.fabricmc.api.ModInitializer;

import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.item.ModItemGroups;
import net.tinaisabelle.supercoolmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperCoolMod implements ModInitializer {
	public static final String MOD_ID = "super-cool-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}