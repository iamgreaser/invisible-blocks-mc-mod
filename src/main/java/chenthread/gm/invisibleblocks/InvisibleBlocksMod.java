package chenthread.gm.invisibleblocks;

import chenthread.gm.invisibleblocks.blocks.InvisibleBlock;
import chenthread.gm.invisibleblocks.blocks.InvisibleBlockEntity;
import chenthread.gm.invisibleblocks.items.IrGogglesItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InvisibleBlocksMod implements ModInitializer {
	public static BlockEntityType<InvisibleBlockEntity> INVISIBLE_BLOCK_ENTITY;
	public static final InvisibleBlock INVISIBLE_BLOCK = new InvisibleBlock(FabricBlockSettings.of(Material.STONE));
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
		new Identifier("invisibleblocks", "general"))
		.icon(() -> new ItemStack(INVISIBLE_BLOCK))
		.build();
	public static final BlockItem INVISIBLE_BLOCK_ITEM = new BlockItem(INVISIBLE_BLOCK, new Item.Settings().group(ITEM_GROUP));

	public static final IrGogglesItem IR_GOGGLES = new IrGogglesItem(new Item.Settings().group(ITEM_GROUP));


	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("invisibleblocks", "invisible_block"), INVISIBLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("invisibleblocks", "invisible_block"), INVISIBLE_BLOCK_ITEM);
		INVISIBLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("invisibleblocks", "invisible_block"),
			BlockEntityType.Builder.create(InvisibleBlockEntity::new, INVISIBLE_BLOCK).build(null));

		Registry.register(Registry.ITEM, new Identifier("invisibleblocks", "ir_goggles"), IR_GOGGLES);
	}
}