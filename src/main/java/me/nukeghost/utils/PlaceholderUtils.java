package me.nukeghost.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static me.nukeghost.MountedCombat.plugin;

public class PlaceholderUtils {

    public static String parsePlaceholdersEnemy(String input, Player rider, Entity enemy, String dmgMulti) {
        Pattern pattern = Pattern.compile("\\{([A-Z_]+)\\}");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String placeholder = matcher.group(0); // e.g., {PLAYER_NAME}, {PLAYER_X}, etc.
            String placeholderKey = matcher.group(1); // e.g., PLAYER_NAME, PLAYER_X, etc.

            // Perform actions based on the placeholder key
            switch (placeholderKey) {
                case "PLAYER_NAME":
                    // Get the player's display name
                    String playerName = rider.getDisplayName(); // Replace with your logic to retrieve the player's name
                    input = input.replace(placeholder, playerName);
                    break;
                case "PLAYER_X":
                    // Get the player's X position
                    double playerX = rider.getLocation().getX(); // Replace with your logic to retrieve the player's X position
                    input = input.replace(placeholder, String.valueOf(playerX));
                    break;
                case "PLAYER_Y":
                    // Get the player's Y position
                    double playerY = rider.getLocation().getY(); // Replace with your logic to retrieve the player's Y position
                    input = input.replace(placeholder, String.valueOf(playerY));
                    break;
                case "PLAYER_Z":
                    // Get the player's Z position
                    double playerZ = rider.getLocation().getZ(); // Replace with your logic to retrieve the player's Z position
                    input = input.replace(placeholder, String.valueOf(playerZ));
                    break;
                case "RIDER_HEALTH":
                    String riderHealth = String.valueOf(rider.getHealth());
                    input = input.replace(placeholder, String.valueOf(riderHealth));
                    break;
                case "DMG_MULTI":
                    input = input.replace(placeholder, String.valueOf(dmgMulti));
                    break;
                case "RIDER_FOOD":
                    String riderFood = String.valueOf(rider.getFoodLevel());
                    input = input.replace(placeholder, String.valueOf(riderFood));
                    break;
            }
        }
        return input;
    }


    public static String parsePlaceholdersNoEnemy(String input, Player rider, String dmgMulti) {
        Pattern pattern = Pattern.compile("\\{([A-Z_]+)\\}");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String placeholder = matcher.group(0); // e.g., {PLAYER_NAME}, {PLAYER_X}, etc.
            String placeholderKey = matcher.group(1); // e.g., PLAYER_NAME, PLAYER_X, etc.

            // Perform actions based on the placeholder key
            switch (placeholderKey) {
                case "PLAYER_NAME":
                    // Get the player's display name
                    String playerName = rider.getDisplayName(); // Replace with your logic to retrieve the player's name
                    input = input.replace(placeholder, playerName);
                    break;
                case "PLAYER_X":
                    // Get the player's X position
                    double playerX = rider.getLocation().getX(); // Replace with your logic to retrieve the player's X position
                    input = input.replace(placeholder, String.valueOf(playerX));
                    break;
                case "PLAYER_Y":
                    // Get the player's Y position
                    double playerY = rider.getLocation().getY(); // Replace with your logic to retrieve the player's Y position
                    input = input.replace(placeholder, String.valueOf(playerY));
                    break;
                case "PLAYER_Z":
                    // Get the player's Z position
                    double playerZ = rider.getLocation().getZ(); // Replace with your logic to retrieve the player's Z position
                    input = input.replace(placeholder, String.valueOf(playerZ));
                    break;
                case "RIDER_HEALTH":
                    String riderHealth = String.valueOf(rider.getHealth());
                    input = input.replace(placeholder, String.valueOf(riderHealth));
                    break;
                case "DMG_MULTI":
                    input = input.replace(placeholder, String.valueOf(dmgMulti));
                    break;
                case "RIDER_FOOD":
                    String riderFood = String.valueOf(rider.getFoodLevel());
                    input = input.replace(placeholder, String.valueOf(riderFood));
                    break;
            }
        }
        return input;
    }
}
