package net.tinaisabelle.supercoolmod.item.custom;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SickleItem extends Item {

    public SickleItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canBeEnchantedWith(ItemStack stack, RegistryEntry<Enchantment> enchantment, EnchantingContext context) {
        return enchantment.matchesKey(Enchantments.FORTUNE)||
                enchantment.matchesKey(Enchantments.UNBREAKING)||
                enchantment.matchesKey(Enchantments.MENDING);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

        if(!world.isClient) {//on the server
            stack.damage(1, miner, EquipmentSlot.MAINHAND);
        }

        return true;
    }
}
