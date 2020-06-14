package io.github.vampirestudios.steampunk_dungeons.items;

import io.github.vampirestudios.steampunk_dungeons.SteampunkDungeons;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class DungeonKeyItem extends Item {
    public DungeonKeyItem(Settings settings) {
        super(settings);


    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity entity, Hand hand) {
        if (!world.isClient) {
            if (entity.getEntityWorld().getRegistryKey() == SteampunkDungeons.dimensionRegistryKey) {
                FabricDimensions.teleport(entity, ((ServerWorld) world).getServer().getWorld(World.OVERWORLD));
            } else {
                FabricDimensions.teleport(entity, ((ServerWorld) world).getServer().getWorld(SteampunkDungeons.WORLD_DIMENSION_KEY));
            }
        }

        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 180));
        entity.setHealth(1);

        return super.use(world, entity, hand);
    }
}


