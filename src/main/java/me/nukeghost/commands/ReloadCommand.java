package me.nukeghost.commands;

import me.nukeghost.MountedCombat;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mountedcombat.reload") || sender.isOp() || !(sender instanceof Player)) {
            try {
                MountedCombat.plugin.reloadConfig();
                MountedCombat.plugin.saveConfig();

                sender.sendMessage(ChatColor.DARK_AQUA + "[M Combat] Reload successful.");
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "[M Combat] Reload failed! Please check console for details.");
                e.printStackTrace();
            }
        }
        return true;
    }
}
