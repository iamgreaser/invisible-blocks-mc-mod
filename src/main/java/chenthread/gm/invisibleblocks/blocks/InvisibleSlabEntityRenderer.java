package chenthread.gm.invisibleblocks.blocks;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;

public class InvisibleSlabEntityRenderer extends BlockEntityRenderer<InvisibleSlabEntity> {
    public InvisibleSlabEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(InvisibleSlabEntity entity, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light, int overlay) {

        InvisibleBlockEntityRenderer.renderAnyInvisible(entity, tickDelta, matrices, vertexConsumers, light, overlay);
    }
}