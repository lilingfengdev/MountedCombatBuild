package me.nukeghost.handlers;

import me.nukeghost.effects.rider.active.PotionEffects;
import me.nukeghost.effects.rider.active.RActiveMultiplier;
import me.nukeghost.utils.DataUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class ModuleHandler {
    public static void runModule(Player p, String moduleName, EntityDamageByEntityEvent event) {
        FileConfiguration config = DataUtils.config;
        //Rider
        String riderActiveSection = moduleName + ".rider.active";
        Double multiplier = RActiveMultiplier.getMultiplier(
                config.getDouble(riderActiveSection + ".multipliers.damage.min"),
                config.getDouble(riderActiveSection + ".multipliers.damage.max"));
        event.setDamage(event.getDamage() * multiplier);

        //get damage and use that to parse the dmg multi placeholders since they work
        String path = riderActiveSection + ".effects";
        for (String section : config.getConfigurationSection(path).getKeys(false)){

            int min = 0; int max = 100;
            boolean chanced = Math.random()*(max-min+1)+min <= config.getDouble(path +"."+section +".chance");
            if (chanced){
                PotionEffects.applyPotion(p, PotionEffectType.getByName(
                                config.getString(path + "." + section + ".effect")),
                        config.getInt(path + "." + section + ".duration"),
                        config.getInt(path + "." + section + ".amplification"));
            }
        }

        //Enemy
        if (!(event.getEntity() instanceof Player)) return;
        String enemyActiveSection = moduleName + ".enemy.active";

        //get damage and use that to parse the dmg multi placeholders since they work
        String pathE = enemyActiveSection + ".effects";
        for (String section : config.getConfigurationSection(pathE).getKeys(false)){
            //System.out.println((config.get(path +"."+section +".condition")));
            //System.out.println((config.get(path +"."+section +".duration")));
            //System.out.println((config.get(path +"."+section +".amplification")));

            int min = 0; int max = 100;
            boolean chanced = Math.random()*(max-min+1)+min <= config.getDouble(pathE +"."+section +".chance");
            if (chanced){
                PotionEffects.applyPotion((Player) event.getEntity(), PotionEffectType.getByName(
                                config.getString(pathE + "." + section + ".effect")),
                        config.getInt(pathE + "." + section + ".duration"),
                        config.getInt(pathE + "." + section + ".amplification"));
            }
        }
    }
}
