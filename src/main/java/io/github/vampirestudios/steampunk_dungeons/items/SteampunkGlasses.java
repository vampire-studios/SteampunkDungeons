package io.github.vampirestudios.steampunk_dungeons.items;
import net.java.games.input.Component;
import net.minecraft.client.Keyboard;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class SteampunkGlasses extends Item implements Wearable {  // TODO: 15.06.2020  Add a texture to this item
/**
Might be a little bit spaghetti to use (if it will disrupt this mod, then remove it or redo it)
*/
    public PlayerEntity player;
    public DimensionType dimensionType;
    public Keyboard key;
    public ItemStack stack;
    public LivingEntity entity;
    public net.java.games.input.Keyboard k;
    public String groupA = String.valueOf(EquipmentSlot.Type.ARMOR);
    public String slot = String.valueOf(EquipmentSlot.HEAD);
    public World world;
    public SteampunkGlasses(Settings setting) {
        super(setting);
    }
    public boolean wearsInSlot(String group, String slot) {
        addEffect();
        return group.equals(EquipmentSlot.Type.ARMOR) && slot.equals(EquipmentSlot.HEAD);
    }
    public TypedActionResult<ItemStack> use(World world, PlayerEntity target, Hand hand) {
        addEffect();
        return equip(target, hand);

    }
    public TypedActionResult<ItemStack> equip(PlayerEntity target, Hand hand) {
        addEffect();
        if(key.equals(k.isKeyDown(Component.Identifier.Key.RIGHT)))
           equipToSlot(target, hand);
        return equipToSlot(target, hand);
    }
    public TypedActionResult<ItemStack> equipToSlot(PlayerEntity target, Hand hand) {
        addEffect();
        if(!wearsInSlot(groupA, slot))
        player.equipStack(EquipmentSlot.HEAD, stack);
        return use(world, target, hand);


    }
    public void addEffect() {
        if(dimensionType.hasSkyLight()) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION));
        player.removeStatusEffect(StatusEffects.WEAKNESS);
        player.removeStatusEffect(StatusEffects.NAUSEA);
        player.removeStatusEffect(StatusEffects.GLOWING);
        }
        if(dimensionType.isUltrawarm()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA));
            player.removeStatusEffect(StatusEffects.GLOWING);
        }
        if(dimensionType.hasEnderDragonFight()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING));
            entity.removeStatusEffect(StatusEffects.NIGHT_VISION);
            player.removeStatusEffect(StatusEffects.WEAKNESS);
            player.removeStatusEffect(StatusEffects.NAUSEA);

        }
    }
}

