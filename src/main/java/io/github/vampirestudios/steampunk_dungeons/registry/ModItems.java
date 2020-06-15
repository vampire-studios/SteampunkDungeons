package io.github.vampirestudios.steampunk_dungeons.registry;

import io.github.vampirestudios.steampunk_dungeons.SteampunkDungeons;
import io.github.vampirestudios.steampunk_dungeons.corrosion.CorrosionPointRegister;
import io.github.vampirestudios.steampunk_dungeons.corrosion.CorrosionPoints;
import io.github.vampirestudios.steampunk_dungeons.items.DungeonKeyItem;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import io.github.vampirestudios.steampunk_dungeons.items.SteampunkGlasses;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import static io.github.vampirestudios.steampunk_dungeons.corrosion.CorrosionPointRegister.convertToCorroded;

public class ModItems {

    public static Item DUNGEON_KEY;
    public static Item COPPER;
    public static Item STEEL;
    public static Item BRONZE;
    public static Item MECHANICAL_SCRAP; //Drops from mobs, can be refined into mechanical parts
    public static Item MECHANICAL_PARTS; //Refined mechanical scrap, used to create basic gears and tools
    public static Item HALF_DAMAGED_MECHANICAL_PART; //Has 50 points in corrosion, can be fixed by tin
    public static Item UNUSABLE_MECHANICAL_PART; //Has 100 points in corrosion, until you will not fix it by tin, it is unusable


    public static void init() {
        RegistryUtils.registerItem(new DungeonKeyItem(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "dungeon_key"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "copper_ingot"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "steel_ingot"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "copper_gear"));
                RegistryUtils.registerItem(new SteampunkGlasses(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "steampunk_glasses"));
        HALF_DAMAGED_MECHANICAL_PART = CorrosionPointRegister.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "half_damaged_mechanical_part"), CorrosionPoints.withCorrosionForHalf(0));
        UNUSABLE_MECHANICAL_PART = CorrosionPointRegister.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "unusable_mechanical_part"), CorrosionPoints.withCorrosionForFull(0));
        MECHANICAL_PARTS = CorrosionPointRegister.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "mechanical_part"), CorrosionPoints.withCorrosionForNone(0));
        convertToCorroded(MECHANICAL_PARTS);
        convertToCorroded(HALF_DAMAGED_MECHANICAL_PART);
        convertToCorroded(UNUSABLE_MECHANICAL_PART);
    }

}
