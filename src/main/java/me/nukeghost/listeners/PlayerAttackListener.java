package me.nukeghost.listeners;

import me.nukeghost.handlers.ModuleHandler;
import me.nukeghost.utils.DataUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerAttackListener implements Listener {
    @EventHandler
    public void onPlayerAttackMounted(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) return;
        Player rider = (Player) e.getDamager();
        if (!rider.isInsideVehicle()) return;
        if (!DataUtils.hasEntityModule(rider.getVehicle().getType())) return;
        //We got a module for specified mount
        String module = DataUtils.getModuleName(rider.getVehicle().getType());

        //Run Rider Logic
        ModuleHandler.runModule(rider, module, e);

        //Run Enemy Logic
    }
}
