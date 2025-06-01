package com.yyz;

import com.mojang.serialization.Codec;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class EnchantInnovation implements ModInitializer {
    public static final String MOD_ID = "enchantinnovation";



    @Override
    public void onInitialize() {

    }
    public static final DataComponentType<Integer> EXP_COMPONENT_TYPE = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            ResourceLocation.fromNamespaceAndPath(EnchantInnovation.MOD_ID, "exp"),
            DataComponentType.<Integer>builder().persistent(Codec.INT).build()
    );
}
