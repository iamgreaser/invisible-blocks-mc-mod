package chenthread.gm.invisibleblocks;

import chenthread.gm.invisibleblocks.blocks.InvisibleBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class InvisibleBlocksModClient implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(InvisibleBlocksMod.INVISIBLE_BLOCK, RenderLayer.getTranslucent());
        BlockEntityRendererRegistry.INSTANCE.register(InvisibleBlocksMod.INVISIBLE_BLOCK_ENTITY, InvisibleBlockEntityRenderer::new);
    }
}