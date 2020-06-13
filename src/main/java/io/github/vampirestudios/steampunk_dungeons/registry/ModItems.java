package io.github.vampirestudios.steampunk_dungeons.registry;

import io.github.vampirestudios.steampunk_dungeons.SteampunkDungeons;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

public class ModItems {

    public static void init() {
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "dungeon_key"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "copper_ingot"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "steel_ingot"));
        RegistryUtils.registerItem(new Item(new Item.Settings().group(ItemGroup.MISC)), new Identifier(SteampunkDungeons.MOD_ID, "copper_gear"));
    }

}
