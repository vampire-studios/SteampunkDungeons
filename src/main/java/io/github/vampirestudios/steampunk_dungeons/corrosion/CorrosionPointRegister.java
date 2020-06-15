package io.github.vampirestudios.steampunk_dungeons.corrosion;

import io.github.vampirestudios.steampunk_dungeons.registry.ModItems;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

/**
 Main class for the corrosion system. In theory, it should work, but I think we should improve it and work on it.
 */
  public static Item registerItem(Item item, Identifier name, CorrosionPoints corrosionValue) {
        RegistryUtils.registerItem(item, name);
        if(RegistryUtils.registerItem(item, name) == null) {
            return registerThisItem(item, name, corrosionValue);
        }
        try {
            CorrosionPointRegister.registerItem(item, name, corrosionValue);
        } catch(NullPointerException exception) {
            throw new ExceptionInInitializerError();
        }
            return item;
    }
    public static Item registerThisItem(Item item, Identifier name, CorrosionPoints corrosionValue) {
        RegistryUtils.registerItem(item, name);
        return item;
    }
    public static void convertToCorroded(Item item) {
        convertToCorroded(ModItems.MECHANICAL_SCRAP); {
            convertToHalfDamaged();
        }
        convertToCorroded(ModItems.HALF_DAMAGED_MECHANICAL_PART); {
            convertToFullDamaged();
        }
        convertToCorroded(ModItems.UNUSABLE_MECHANICAL_PART); {
            convertToSameValue();
        }

    }
    public static Item convertToHalfDamaged() {
        CorrosionPoints.getCorrosionInHalf(); {
       replaceItemWith(ModItems.MECHANICAL_PARTS, ModItems.HALF_DAMAGED_MECHANICAL_PART);
        }
        return convertToHalfDamaged();


    }
    public static Item convertToFullDamaged() {
        CorrosionPoints.getCorrosionInFull(); {
        replaceItemWith(ModItems.HALF_DAMAGED_MECHANICAL_PART, ModItems.UNUSABLE_MECHANICAL_PART);
        }
        return convertToFullDamaged();
    }
    public static Item convertToSameValue() {
        CorrosionPoints.getCorrosionInZero(); {
        return replaceItemWith(ModItems.UNUSABLE_MECHANICAL_PART, ModItems.UNUSABLE_MECHANICAL_PART);
        }
    }
    public static Item replaceItemWith(Item item, Item replacingItem) {
        replaceItemWith(item, replacingItem);
        return replacingItem;
    }
}
