package io.github.vampirestudios.steampunk_dungeons.registry;

import io.github.vampirestudios.steampunk_dungeons.SteampunkDungeons;
import io.github.vampirestudios.vampirelib.utils.registry.RegistryUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.util.Identifier;

public class ModBlocks {
    static Block LIQUID_TIN;

    public static void init() {
        RegistryUtils.register(new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)), new Identifier(SteampunkDungeons.MOD_ID, "malachite_ore"));
        RegistryUtils.register(new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)), new Identifier(SteampunkDungeons.MOD_ID, "steel_ore"));
        RegistryUtils.register(new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), new Identifier(SteampunkDungeons.MOD_ID, "copper_block"));
        RegistryUtils.register(new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), new Identifier(SteampunkDungeons.MOD_ID, "steel_block"));
        RegistryUtils.register(new Block(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)), new Identifier(SteampunkDungeons.MOD_ID, "tin_block"));
        RegistryUtils.register(new Block(AbstractBlock.Settings.copy(Blocks.GOLD_ORE)), new Identifier(SteampunkDungeons.MOD_ID, "tin_ore"));
        LIQUID_TIN = RegistryUtils.register(new Block(FluidBlock.Settings.copy(Blocks.WATER)), new Identifier(SteampunkDungeons.MOD_ID, "liquid_tin"));
    }

}
