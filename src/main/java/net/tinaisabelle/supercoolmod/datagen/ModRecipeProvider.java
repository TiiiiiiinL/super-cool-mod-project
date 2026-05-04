package net.tinaisabelle.supercoolmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.tinaisabelle.supercoolmod.block.ModBlocks;
import net.tinaisabelle.supercoolmod.item.ModItems;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> RICE_SMOKABLE = List.of(ModItems.RAW_RICE);
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.RAW_RICE), RecipeCategory.FOOD,
                ModItems.COOKED_RICE, 0.35f, 300
        ).criterion(hasItem(ModItems.RAW_RICE), conditionsFromItem(ModItems.RAW_RICE))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WOODEN_SICKLE) //ändra till alla material
                .pattern("III")
                .pattern(" SI")
                .pattern("S  ")
                .input('I', Ingredient.fromTag(ItemTags.PLANKS))
                .input('S', Items.STICK)
                .criterion(hasItem(Items.OAK_PLANKS), conditionsFromItem(Items.OAK_PLANKS))
                .offerTo(exporter);


        List<ItemConvertible> JADE_SMELTABLES = List.of(ModItems.RAW_JADE_ORE, ModBlocks.JADE_ORE_BLOCK);

        offerSmelting(exporter, JADE_SMELTABLES, RecipeCategory.MISC, ModItems.JADE_ORE,0.25f, 200, "jade");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.JADE_ORE, RecipeCategory.DECORATIONS, ModBlocks.JADE_BLOCK);

        /*
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.JADE_BLOCK)
                .pattern("JJJ")
                .pattern("JJJ")
                .pattern("JJJ")
                .input('J', ModItems.JADE_ORE)
                .criterion(hasItem(ModItems.JADE_ORE), conditionsFromItem(ModItems.JADE_ORE))
                .offerTo(exporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JADE_ORE, 9)
                .input(ModBlocks.JADE_BLOCK)
                .criterion(hasItem(ModBlocks.JADE_BLOCK), conditionsFromItem(ModBlocks.JADE_BLOCK))
                .offerTo(exporter);

         */

    }
}
