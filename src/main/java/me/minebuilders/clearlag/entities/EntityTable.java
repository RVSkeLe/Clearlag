package me.minebuilders.clearlag.entities;

import me.minebuilders.clearlag.entities.attributes.EntityAttribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bob7l
 */
public class EntityTable {

    // Using HashMap to map EntityType to List<EntityAttribute<Entity>>
    private final Map<EntityType, List<EntityAttribute<Entity>>> entityTable = new HashMap<>();

    private static final List<EntityAttribute<Entity>> EMPTY_COLLECTION = new ArrayList<>(1);

    public boolean containsEntity(Entity entity) {
        List<EntityAttribute<Entity>> con = entityTable.get(entity.getType());

        return con != null
                && con.stream().allMatch(e -> e.containsData(entity));
    }

    public void setEntityAttributes(EntityType type, List<EntityAttribute<Entity>> entityAttributes) {
        entityTable.put(type, entityAttributes);
    }

    public void setEntity(EntityType type) {
        entityTable.put(type, EMPTY_COLLECTION);
    }
}
