package chenthread.gm.invisibleblocks.blocks;

import chenthread.gm.invisibleblocks.InvisibleBlocksMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class InvisibleBlockEntityRenderer extends BlockEntityRenderer<InvisibleBlockEntity> {
    private static ItemStack STACK = new ItemStack(InvisibleBlocksMod.INVISIBLE_BLOCK, 1);

    public InvisibleBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(InvisibleBlockEntity entity, float tickDelta, MatrixStack matrices,
            VertexConsumerProvider vertexConsumers, int light, int overlay) {

        // MATRIX 0 PUSH 1
        matrices.push();
        try {
            MinecraftClient client = MinecraftClient.getInstance();
            PlayerEntity player = client.player;

            // We MUST have a player.
            if (player == null) {
                return;
            }

            // Find out what we're wearing on our head.
            ItemStack stack = player.getEquippedStack(EquipmentSlot.HEAD);

            // It MUST be something.
            if (stack.isEmpty()) {
                return;
            }

            // It MUST also be IR goggles.
            if (stack.getItem() != InvisibleBlocksMod.IR_GOGGLES) {
                return;
            }

            // OK, we can render things!
            ItemRenderer renderer = client.getItemRenderer();
            matrices.translate(0.5d, 0.5d, 0.5d);
            renderer.renderItem(STACK, ModelTransformation.Mode.NONE, light, overlay, matrices, vertexConsumers);

        } finally {
            // MATRIX 1 POP 0
            matrices.pop();
        }
    }
}