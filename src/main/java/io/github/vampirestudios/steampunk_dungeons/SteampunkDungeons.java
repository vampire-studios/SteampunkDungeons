package io.github.vampirestudios.steampunk_dungeons;

import io.github.vampirestudios.steampunk_dungeons.world.dimension.VoidChunkGenerator;
import io.github.vampirestudios.steampunk_dungeons.registry.ModBlocks;
import io.github.vampirestudios.steampunk_dungeons.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SteampunkDungeons implements ModInitializer {
    static MinecraftClient mc;
    public static Logger LOGGER = LogManager.getLogger();
     public static void sendDebugMessage(String message) {
        mc.player.sendChatMessage("STEAMPUNKDUNGEONS/" + message);
    }

    public static final String MOD_ID = "steampunk_dungeons";
    public static final String MOD_NAME = "Steampunk Dungeons";
    public static final RegistryKey<World> WORLD_DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION, new Identifier(MOD_ID, "steampunk_dungeons"));
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "item_group"))
            .icon(() -> new ItemStack(ModItems.DUNGEON_KEY))
            .build();

    public static RegistryKey<World> dimensionRegistryKey;

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        ModItems.init();
        ModBlocks.init();
        
        Registry.register(Registry.CHUNK_GENERATOR, new Identifier(MOD_ID, "steampunk_dungeons"), VoidChunkGenerator.CODEC);

        dimensionRegistryKey = RegistryKey.of(Registry.DIMENSION, new Identifier(MOD_ID, "steampunk_dungeons"));

        FabricDimensions.registerDefaultPlacer(dimensionRegistryKey, SteampunkDungeons::placeEntityInVoid);

    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    private static BlockPattern.TeleportTarget placeEntity(Entity teleported, ServerWorld destination, Direction portalDir, double horizontalOffset, double verticalOffset) {
        return new BlockPattern.TeleportTarget(new Vec3d(0, 100, 0), Vec3d.ZERO, 0);
    }

    private static BlockPattern.TeleportTarget placeEntityInVoid(Entity teleported, ServerWorld destination, Direction portalDir, double horizontalOffset, double verticalOffset) {
        destination.setBlockState(new BlockPos(0, 100, 0), Blocks.DIAMOND_BLOCK.getDefaultState());
        destination.setBlockState(new BlockPos(0, 101, 0), Blocks.TORCH.getDefaultState());
        return new BlockPattern.TeleportTarget(new Vec3d(0.5, 101, 0.5), Vec3d.ZERO, 0);
    }

}
