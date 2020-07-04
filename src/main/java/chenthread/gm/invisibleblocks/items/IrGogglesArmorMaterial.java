package chenthread.gm.invisibleblocks.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum IrGogglesArmorMaterial implements ArmorMaterial {
    STANDARD;

    @Override
    public int getDurability(EquipmentSlot slot) {
        return 11 * 5; // Vanilla durability for head, x 5.
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_ANVIL_LAND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }

    @Override
    public String getName() {
        return "ir_goggles";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.0f;
    }
}