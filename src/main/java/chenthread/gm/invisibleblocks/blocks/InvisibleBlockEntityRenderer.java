package chenthread.gm.invisibleblocks.blocks;

import java.util.Random;

import chenthread.gm.invisibleblocks.InvisibleBlocksModClient;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InvisibleBlockEntityRenderer extends BlockEntityRenderer<InvisibleBlockEntity> {
    protected static Random RANDOM = new Random();

    public InvisibleBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(InvisibleBlockEntity entity, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light, int overlay) {

        InvisibleBlockEntityRenderer.renderAnyInvisible(entity, tickDelta, matrices, vertexConsumers, light, overlay);
    }

    public static void renderAnyInvisible(BlockEntity entity, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light, int overlay) {
        // Make sure the blocks are actually visible
        if (!InvisibleBlocksModClient.invisibleBlocksAreVisible()) {
            return;
        }

        // OK, we can render things!

        // MATRIX 0 PUSH 1
        matrices.push();
        try {
            MinecraftClient client = MinecraftClient.getInstance();

            BlockPos bpos = entity.getPos();
            World world = entity.getWorld();
            BlockState state = entity.getCachedState();

            BlockRenderManager brm = client.getBlockRenderManager();
            BlockModelRenderer bmr = brm.getModelRenderer();
            BakedModel model = brm.getModel(state);

            //matrices.translate(0.5d, 0.5d, 0.5d);
            bmr.render(
                world,
                model,
                state,
                bpos,
                matrices,
                vertexConsumers.getBuffer(RenderLayer.getTranslucent()),
                false,
                RANDOM,
                state.getRenderingSeed(bpos),
                0);
            //renderer.renderItem(null, STACK, ModelTransformation.Mode.NONE, false, matrices, vertexConsumers, null, light, overlay);

        } finally {
            // MATRIX 1 POP 0
            matrices.pop();
        }
    }
}