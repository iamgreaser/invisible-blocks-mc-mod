package chenthread.gm.invisibleblocks.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Wearable;

public class IrGogglesItem extends Item implements Wearable {
    public IrGogglesItem(Settings settings) {
        super(settings);
    }

    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }
}