package com.yyz.enchantinnovation.neoforge;

import com.yyz.enchantinnovation.EnchantmentUtils;
import com.yyz.enchantinnovation.EnchantInnovation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.ShieldBlockEvent;
import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

@Mod.EventBusSubscriber(modid = EnchantInnovation.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NeoForgeEvents {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null) return;
        ItemStack stack = player.getMainHandItem();
        Item item = stack.getItem();
        if (item instanceof PickaxeItem || item instanceof AxeItem) {
            EnchantmentUtils.addExp(stack, 1);
        }
    }

    @SubscribeEvent
    public static void onXpPickup(PlayerXpEvent.PickupXp event) {
        Player player = event.getEntity();
        ItemStack stack = player.getMainHandItem();
        if (stack.getItem() instanceof SwordItem) {
            int xp = event.getOrb().value;
            EnchantmentUtils.addExp(stack, xp);
        }
    }

    @SubscribeEvent
    public static void onArrowHit(ProjectileImpactEvent.Arrow event) {
        if (event.getRayTraceResult().getType() == net.minecraft.world.phys.HitResult.Type.ENTITY) {
            if (event.getArrow().getOwner() instanceof Player player) {
                ItemStack bow = player.getMainHandItem();
                if (bow.getItem() instanceof BowItem) {
                    EnchantmentUtils.addExp(bow, 10);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack stack = event.getShield();
            if (stack.getItem() instanceof ShieldItem) {
                EnchantmentUtils.addExp(stack, 10);
            }
        }
    }
}
