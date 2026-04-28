package net.tinaisabelle.supercoolmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

//för drinkar kolla #8 vid 3.10
public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(3).build();

    public static final FoodComponent COOKED_RICE = new FoodComponent.Builder().nutrition(5).build();

    public static final FoodComponent CILANTRO = new FoodComponent.Builder().nutrition(0).
            statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200), 0.7f).
            statusEffect(new StatusEffectInstance(StatusEffects.POISON,100), 0.3f).build();

}
