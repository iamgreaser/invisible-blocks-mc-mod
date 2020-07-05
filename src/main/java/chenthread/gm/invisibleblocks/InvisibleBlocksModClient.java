package chenthread.gm.invisibleblocks;

import chenthread.gm.invisibleblocks.blocks.InvisibleBlockEntityRenderer;
import chenthread.gm.invisibleblocks.blocks.InvisibleSlabEntityRenderer;
//import chenthread.gm.invisibleblocks.blocks.InvisibleBlockEntityRenderer;
import chenthread.gm.invisibleblocks.blocks.InvisibleStairsEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class InvisibleBlocksModClient implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(InvisibleBlocksMod.INVISIBLE_BLOCK, RenderLayer.getTranslucent());
        BlockEntityRendererRegistry.INSTANCE.register(InvisibleBlocksMod.INVISIBLE_BLOCK_ENTITY, InvisibleBlockEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(InvisibleBlocksMod.INVISIBLE_STAIRS, RenderLayer.getTranslucent());
        BlockEntityRendererRegistry.INSTANCE.register(InvisibleBlocksMod.INVISIBLE_STAIRS_ENTITY, InvisibleStairsEntityRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(InvisibleBlocksMod.INVISIBLE_SLAB, RenderLayer.getTranslucent());
        BlockEntityRendererRegistry.INSTANCE.register(InvisibleBlocksMod.INVISIBLE_SLAB_ENTITY, InvisibleSlabEntityRenderer::new);
    }

    public static boolean invisibleBlocksAreVisible() {
        MinecraftClient client = MinecraftClient.getInstance();

        PlayerEntity player = client.player;
        if (player == null) {
            return false;
        }

        ItemStack stack = player.getEquippedStack(EquipmentSlot.HEAD);
        if (stack.isEmpty()) {
            return false;
        }

        if (stack.getItem() != InvisibleBlocksMod.IR_GOGGLES) {
            return false;
        }

        return true;
    }
}