package me.minebuilders.clearlag.listeners;

import me.minebuilders.clearlag.annotations.ConfigPath;
import me.minebuilders.clearlag.annotations.ConfigValue;
import me.minebuilders.clearlag.modules.EventModule;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;

@ConfigPath(path = "tnt-reducer")
public class TntReduceListener extends EventModule {

    @ConfigValue
    private final int checkRadius = 5;

    @ConfigValue
    private final int maxPrimed = 3;

    @EventHandler
    public void onBoom(EntityExplodeEvent event) {
        Entity e = event.getEntity();
        if (e.getType() != EntityType.TNT) return;

        int counter = 0;

        for (Entity tnt : e.getLocation().getNearbyEntitiesByType(TNTPrimed.class,checkRadius, checkRadius, checkRadius)) {
            counter++;
            if (counter > maxPrimed)
                tnt.remove();
        }
    }

}
