package chenthread.gm.invisibleblocks;

import chenthread.gm.invisibleblocks.blocks.InvisibleBlock;
import chenthread.gm.invisibleblocks.blocks.InvisibleBlockEntity;
import chenthread.gm.invisibleblocks.blocks.InvisibleSlab;
import chenthread.gm.invisibleblocks.blocks.InvisibleSlabEntity;
import chenthread.gm.invisibleblocks.blocks.InvisibleStairsEntity;
import chenthread.gm.invisibleblocks.blocks.InvisibleStairs;
import chenthread.gm.invisibleblocks.items.IrGogglesItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InvisibleBlocksMod implements ModInitializer {
	public static final AbstractBlock.Settings INVISIBLE_SETTINGS = FabricBlockSettings.of(Material.STONE).nonOpaque();
	public static final InvisibleBlock INVISIBLE_BLOCK = new InvisibleBlock(INVISIBLE_SETTINGS);
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(
		new Identifier("invisibleblocks", "general"))
		.icon(() -> new ItemStack(INVISIBLE_BLOCK))
		.build();
	public static final BlockItem INVISIBLE_BLOCK_ITEM = new BlockItem(INVISIBLE_BLOCK, new Item.Settings().group(ITEM_GROUP));
	public static BlockEntityType<InvisibleBlockEntity> INVISIBLE_BLOCK_ENTITY;

	public static final IrGogglesItem IR_GOGGLES = new IrGogglesItem(new Item.Settings().group(ITEM_GROUP));

	// Alt block types
	public static final StairsBlock INVISIBLE_STAIRS = new InvisibleStairs(INVISIBLE_SETTINGS);
	public static final BlockItem INVISIBLE_STAIRS_ITEM = new BlockItem(INVISIBLE_STAIRS, new Item.Settings().group(ITEM_GROUP));
	public static BlockEntityType<InvisibleStairsEntity> INVISIBLE_STAIRS_ENTITY;

	public static final SlabBlock INVISIBLE_SLAB = new InvisibleSlab(INVISIBLE_SETTINGS);
	public static final BlockItem INVISIBLE_SLAB_ITEM = new BlockItem(INVISIBLE_SLAB, new Item.Settings().group(ITEM_GROUP));
	public static BlockEntityType<InvisibleSlabEntity> INVISIBLE_SLAB_ENTITY;


	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("invisibleblocks", "invisible_block"), INVISIBLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("invisibleblocks", "invisible_block"), INVISIBLE_BLOCK_ITEM);
		INVISIBLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("invisibleblocks", "invisible_block"),
			BlockEntityType.Builder.create(InvisibleBlockEntity::new, INVISIBLE_BLOCK).build(null));

		Registry.register(Registry.ITEM, new Identifier("invisibleblocks", "ir_goggles"), IR_GOGGLES);

		// Alt block types
		Registry.register(Registry.BLOCK, new Identifier("invisibleblocks", "invisible_stairs"), INVISIBLE_STAIRS);
		Registry.register(Registry.ITEM, new Identifier("invisibleblocks", "invisible_stairs"), INVISIBLE_STAIRS_ITEM);
		INVISIBLE_STAIRS_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("invisibleblocks", "invisible_stairs"),
			BlockEntityType.Builder.create(InvisibleStairsEntity::new, INVISIBLE_STAIRS).build(null));

		Registry.register(Registry.BLOCK, new Identifier("invisibleblocks", "invisible_slab"), INVISIBLE_SLAB);
		Registry.register(Registry.ITEM, new Identifier("invisibleblocks", "invisible_slab"), INVISIBLE_SLAB_ITEM);
		INVISIBLE_SLAB_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("invisibleblocks", "invisible_slab"),
			BlockEntityType.Builder.create(InvisibleSlabEntity::new, INVISIBLE_SLAB).build(null));
	}
}