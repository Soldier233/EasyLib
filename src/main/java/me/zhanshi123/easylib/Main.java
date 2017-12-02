package me.zhanshi123.easylib;

import me.zhanshi123.easylib.commands.EasyCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new EasyCommandManager();
    }

    @Override
    public void onDisable() {

    }
}
