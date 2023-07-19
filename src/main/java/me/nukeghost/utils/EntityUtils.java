package me.nukeghost.utils;

import org.bukkit.entity.EntityType;

public class EntityUtils {
    public static EntityType getEntityType(String entityName) {
        if (entityName == null) {
            //Shut Down Plugin with an error saying this module cannot be found
        }
        try {
            return EntityType.valueOf(entityName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Entity type not found
        }
    }
}
