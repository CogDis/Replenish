package com.precipicegames.zeryl.replenish;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class Replenish extends JavaPlugin {
    
    private final ReplenishBlockListener blockListener = new ReplenishBlockListener(this);
    private final ReplenishPlayerListener playerListener = new ReplenishPlayerListener(this);
    
    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        PluginDescriptionFile pdf = this.getDescription();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);
        
        System.out.println(pdf.getName() + " is now enabled");
    }
    
    @Override
    public void onDisable() {
        PluginDescriptionFile pdf = this.getDescription();
        System.out.println(pdf.getName() + " is now disbled");
    }
}
