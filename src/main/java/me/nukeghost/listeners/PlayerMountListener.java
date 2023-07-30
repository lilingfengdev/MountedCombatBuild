package me.nukeghost.listeners;

import me.nukeghost.MountedCombat;
import me.nukeghost.handlers.ModuleHandler;
import me.nukeghost.utils.DataUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class PlayerMountListener implements Listener {

    @EventHandler
    public void onPlayerRide(VehicleEnterEvent e) {
        Player rider = (Player) e.getEntered();
        if (!rider.hasPermission("mountedcombat.passive")) return;
        if (!DataUtils.hasEntityModule(e.getVehicle().getType())) return;

        String module = DataUtils.getModuleName(rider.getVehicle().getType());
        MountedCombat.playerModuleNameHashMap.put(rider, module);
    }

    @EventHandler
    public void onPlayerExitVehicle(VehicleExitEvent e) {
        Player rider = (Player) e.getExited();
        if (!rider.hasPermission("mountedcombat.passive")) return;
        if (!DataUtils.hasEntityModule(e.getVehicle().getType())) return;

        String module = DataUtils.getModuleName(e.getVehicle().getType());
        if (MountedCombat.playerModuleNameHashMap.containsKey(rider)) {
            MountedCombat.playerModuleNameHashMap.remove(rider);
        }

    }
}
