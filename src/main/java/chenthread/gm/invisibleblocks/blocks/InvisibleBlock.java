package chenthread.gm.invisibleblocks.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class InvisibleBlock extends Block implements BlockEntityProvider {

    public InvisibleBlock(Settings settings) {
        super(settings.nonOpaque());
    }

    @Environment(EnvType.CLIENT)
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return 1.0F;
    }

    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Environment(value = EnvType.CLIENT)
    public boolean isVisibleForClient(World world) {
        MinecraftClient client = MinecraftClient.getInstance();

        PlayerEntity player = client.player;
        if (player == null) {
            return false;
        }

        ItemStack stack = player.getEquippedStack(EquipmentSlot.HEAD);
        if (stack.isEmpty()) {
            return false;
        }

        // TODO: Actually check if this is a stack of IR goggles

        return true;
    }

    public boolean isVisible(BlockView view) {
        if (view instanceof World) {
            World world = (World) view;
            if (world.isClient) {
                return this.isVisibleForClient(world);
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        if (this.isVisible(view)) {
            return super.getOutlineShape(state, view, pos, ctx);
        } else {
            return VoxelShapes.empty();
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        return super.getOutlineShape(state, view, pos, ctx);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new InvisibleBlockEntity();
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.INVISIBLE;
    }
}