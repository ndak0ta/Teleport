package com.minecraft.plugins;

import org.bukkit.plugin.java.JavaPlugin;

import com.minecraft.plugins.commands.Teleport;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("tp").setExecutor(new Teleport());
    }
}
