package net.tinaisabelle.supercoolmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.tinaisabelle.supercoolmod.entity.ModEntities;
import net.tinaisabelle.supercoolmod.item.ModItems;

public class TomatoEntity extends ThrownItemEntity {
    public TomatoEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public TomatoEntity(World world, LivingEntity owner) {
        super(ModEntities.TOMATO, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.TOMATO;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient()) {

            ((ServerWorld) this.getWorld()).spawnParticles(
                    new ItemStackParticleEffect(ParticleTypes.ITEM, new ItemStack(ModItems.TOMATO)),
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    8,
                    0.3, 0.3, 0.3,
                    0.03
            );

            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 1.0F);

        Vec3d knock = this.getVelocity();
        entity.addVelocity(knock.x, 0.2, knock.z);
        entity.velocityModified = true;

        if (entity instanceof LivingEntity living) {
            living.addStatusEffect(
                    new StatusEffectInstance(StatusEffects.WEAKNESS, 60, 0)
            );
        }
    }
}
