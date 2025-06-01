package com.yyz.forge.enchantinnovation;

import com.yyz.enchantinnovation.EnchantInnovation;
import net.minecraftforge.fml.common.Mod;

@Mod(EnchantInnovation.MOD_ID)
public final class EnchantInnovationForge {
    public EnchantInnovationForge() {
        // Run our common setup.
        EnchantInnovation.init();
    }
}
