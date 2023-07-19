package me.nukeghost.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

import static me.nukeghost.MountedCombat.plugin;

public class DataUtils {
    public static FileConfiguration config = plugin.getConfig();
    private static List<String> modules = new ArrayList<>();
    private static List<EntityType> activeEntities = new ArrayList<>();

    public static void loadModuleData() {
        modules = config.getStringList("active-modules");

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[M Combat] Loaded config.");

        for (String moduleName : modules) {
            String mountName = config.getString(moduleName + ".mount");
            activeEntities.add(EntityUtils.getEntityType(mountName));
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[M Combat] Registered " + ChatColor.YELLOW +
                activeEntities.size() + " " + ChatColor.DARK_AQUA + "active modules.");
    }

    public static boolean hasEntityModule(EntityType mountType) {
        for (EntityType type : activeEntities) {
            if (type.equals(mountType)) {
                return true;
            }
        }

        return false;
    }

    public static String getModuleName(EntityType mountType) {
        for (String moduleName : modules) {
            String mountName = config.getString(moduleName + ".mount");
            if (mountType.equals(EntityUtils.getEntityType(mountName))) {
                return moduleName;
            }
        }
        Bukkit.getLogger().severe("An error occurred while finding module for " + mountType.getName());
        return null;
    }
}
