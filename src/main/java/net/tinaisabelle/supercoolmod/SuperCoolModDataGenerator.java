package net.tinaisabelle.supercoolmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.tinaisabelle.supercoolmod.datagen.ModBlockTagProvider;
import net.tinaisabelle.supercoolmod.datagen.ModItemTagProvider;
import net.tinaisabelle.supercoolmod.datagen.ModLootTableProvider;
import net.tinaisabelle.supercoolmod.datagen.ModModelProvider;

public class SuperCoolModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
	}
}
