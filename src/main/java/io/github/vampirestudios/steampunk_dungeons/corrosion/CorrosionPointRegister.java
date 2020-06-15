package io.github.vampirestudios.steampunk_dungeons.corrosion;

import io.github.vampirestudios.steampunk_dungeons.registry.ModItems;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import javax.naming.OperationNotSupportedException;

/**
 Main class for the corrosion system. In theory, it should work, but I think we should improve it and work on it.
 */
public class CorrosionPointRegister {
    public static Item registerItem(Item item, Identifier name, CorrosionPoints corrosionValue) {
        RegistryUtils.registerItem(item, name);
        return item;
    }
    public static Item convertToCorroded(Item item) {
        if(convertToCorroded(ModItems.MECHANICAL_SCRAP) != null) {
            convertToHalfDamaged();
        }
        if(convertToCorroded(ModItems.HALF_DAMAGED_MECHANICAL_PART) != null){
            convertToFullDamaged();
        }
        if(convertToCorroded(ModItems.UNUSABLE_MECHANICAL_PART) != null) {
            convertToSameValue();
        }
        return item;

    }
    public static Item convertToHalfDamaged() {
        CorrosionPoints.getCorrosionInHalf(); {
       replaceItemWith(ModItems.MECHANICAL_PARTS, ModItems.HALF_DAMAGED_MECHANICAL_PART);
        }
        return convertToHalfDamaged();


    }
    public static Item convertToFullDamaged() {
        if(CorrosionPoints.getCorrosionInFull() != null) {
        replaceItemWith(ModItems.HALF_DAMAGED_MECHANICAL_PART, ModItems.UNUSABLE_MECHANICAL_PART);
        }
        return replaceItemWith(ModItems.HALF_DAMAGED_MECHANICAL_PART, ModItems.UNUSABLE_MECHANICAL_PART);
    }
    public static Item convertToSameValue() {
        CorrosionPoints.getCorrosionInZero(); {
        return replaceItemWith(ModItems.UNUSABLE_MECHANICAL_PART, ModItems.UNUSABLE_MECHANICAL_PART);
        }
    }
    public static Item replaceItemWith(Item item, Item replacingItem) {
        replaceItemWith(item, replacingItem);
        item = Items.AIR;
        return replacingItem;
    }
}
