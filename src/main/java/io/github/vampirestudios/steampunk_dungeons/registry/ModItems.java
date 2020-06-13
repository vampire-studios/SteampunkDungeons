package io.github.vampirestudios.steampunk_dungeons.registry;

import io.github.vampirestudios.steampunk_dungeons.SteampunkDungeons;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class ModItems {

    public static Item DUNGEON_KEY;
    public static Item COPPER;
    public static Item STEEL;
    public static Item BRONZE;
    public static Item MECHANICAL_SCRAP; //Drops from mobs, can be refined into mechanical parts
    public static Item MECHANICAL_PARTS; //Refined mechanical scrap, used to create basic gears and tools






    

    public static void init() {
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "dungeon_key"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "copper_ingot"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "steel_ingot"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "copper_gear"));
    }

}
