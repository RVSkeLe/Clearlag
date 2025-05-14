package me.minebuilders.clearlag.entities.attributes;

import org.bukkit.entity.Entity;

/**
 * @author bob7l
 */
public class EntityNameAttribute extends EntityAttribute<Entity> {

    private final String name;

    public EntityNameAttribute(String name) {
        this.name = name;
    }

    @Override
    public boolean containsData(Entity entity) {
        String entityName = entity.customName().toString();
        return entityName != null
                && !reversed == name.equals(entityName);
    }

}