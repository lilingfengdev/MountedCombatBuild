package me.nukeghost;

import me.nukeghost.commands.ReloadCommand;
import me.nukeghost.listeners.PlayerAttackListener;
import me.nukeghost.utils.DataUtils;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MountedCombat extends JavaPlugin implements Listener{

    public static MountedCombat plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("mcreload").setExecutor(new ReloadCommand());
        registerListeners();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        DataUtils.loadModuleData();
    }

    void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerAttackListener(), this);
    }

}
