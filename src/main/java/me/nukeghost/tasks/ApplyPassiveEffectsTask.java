package me.nukeghost.tasks;

import me.nukeghost.MountedCombat;
import me.nukeghost.handlers.ModuleHandler;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ApplyPassiveEffectsTask extends BukkitRunnable {
    @Override
    public void run() {
        for (Player player : MountedCombat.playerModuleNameHashMap.keySet()) {
            String module = MountedCombat.playerModuleNameHashMap.get(player);
            ModuleHandler.runModulePassive(player, module);
        }
    }
}
