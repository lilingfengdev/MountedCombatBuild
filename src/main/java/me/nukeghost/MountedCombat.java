package me.nukeghost;

import me.nukeghost.commands.ReloadCommand;
import me.nukeghost.listeners.PlayerAttackListener;
import me.nukeghost.listeners.PlayerMountListener;
import me.nukeghost.tasks.ApplyPassiveEffectsTask;
import me.nukeghost.utils.DataUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class MountedCombat extends JavaPlugin implements Listener{

    public static MountedCombat plugin;
    public static HashMap<Player, String> playerModuleNameHashMap = new HashMap<>();
    private int delay;

    @Override
    public void onEnable() {
        plugin = this;
        delay = getConfig().getInt("passive-delay");
        getCommand("mcreload").setExecutor(new ReloadCommand());
        registerListeners();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        DataUtils.loadModuleData();

        new ApplyPassiveEffectsTask().runTaskTimer(this, 1, delay);
    }

    void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerAttackListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMountListener(), this);
    }

}
