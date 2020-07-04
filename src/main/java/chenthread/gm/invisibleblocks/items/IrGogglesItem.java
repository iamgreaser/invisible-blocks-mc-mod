package chenthread.gm.invisibleblocks.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;

public class IrGogglesItem extends ArmorItem {
    public IrGogglesItem(Settings settings) {
        super(IrGogglesArmorMaterial.STANDARD, EquipmentSlot.HEAD, settings);
    }
}