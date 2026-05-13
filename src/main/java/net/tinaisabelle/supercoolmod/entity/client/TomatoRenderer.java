package net.tinaisabelle.supercoolmod.entity.client;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.tinaisabelle.supercoolmod.SuperCoolMod;
import net.tinaisabelle.supercoolmod.entity.custom.TomatoEntity;

public class TomatoRenderer extends EntityRenderer<TomatoEntity> {

    public TomatoRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(TomatoEntity entity) {
        return Identifier.of(SuperCoolMod.MOD_ID, "textures/item/tomato.png");
    }
}
