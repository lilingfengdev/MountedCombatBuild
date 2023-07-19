package me.nukeghost.effects.rider.active;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionEffects {
    public static void applyPotion(Player rider, PotionEffectType potionType, int duration, int amplification) {
        rider.addPotionEffect(new PotionEffect(potionType, duration, amplification));
    }
}
