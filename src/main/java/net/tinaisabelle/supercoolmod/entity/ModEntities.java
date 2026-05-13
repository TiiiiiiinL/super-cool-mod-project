package net.tinaisabelle.supercoolmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;
import net.tinaisabelle.supercoolmod.entity.custom.TomatoEntity;

public class ModEntities {
    public static final EntityType<TomatoEntity> TOMATO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SuperCoolMod.MOD_ID, "tomato"),
                EntityType.Builder.<TomatoEntity>create(TomatoEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f)
                    .build()
            );
    public static void registerEntities() {
        SuperCoolMod.LOGGER.info("Registering Entities");
    }
}
