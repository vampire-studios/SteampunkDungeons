package io.github.vampirestudios.steampunk_dungeons.items;


import io.github.vampirestudios.steampunk_dungeons.SteampunkDungeons;
import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class DungeonKeyItem extends Item {
    public DungeonKeyItem(Settings settings) {
        super(settings);


    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) { //My dumbass made this the action...FUCKKK it would work if there was a food component...anyone got ideas? -Tridentflayer/Kayden
        ItemStack newStack = super.finishUsing(stack, world, entity);

        if (!world.isClient) {
            if (entity.getEntityWorld().getRegistryKey() == SteampunkDungeons.dimensionRegistryKey ) {
                FabricDimensions.teleport(entity, ((ServerWorld) world).getServer().getWorld(World.OVERWORLD));
            } else {
                FabricDimensions.teleport(entity, ((ServerWorld) world).getServer().getWorld(SteampunkDungeons.WORLD_DIMENSION_KEY));
            }
        }

        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 80));
        entity.setHealth(Math.min(entity.getHealth(), entity.getMaxHealth()));

        return newStack;
    }

}
