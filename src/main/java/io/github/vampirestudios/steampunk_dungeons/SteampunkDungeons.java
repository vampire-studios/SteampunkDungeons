package io.github.vampirestudios.steampunk_dungeons;

import io.github.vampirestudios.steampunk_dungeons.registry.ModBlocks;
import io.github.vampirestudios.steampunk_dungeons.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SteampunkDungeons implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "steampunk_dungeons";
    public static final String MOD_NAME = "Steampunk Dungeons";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        ModItems.init();
        ModBlocks.init();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}