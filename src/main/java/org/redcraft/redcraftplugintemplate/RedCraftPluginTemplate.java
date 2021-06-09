package org.redcraft.redcraftplugintemplate;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;
import org.bukkit.scheduler.BukkitScheduler;
import org.redcraft.redcraftplugintemplate.database.DatabaseManager;
import org.redcraft.redcraftplugintemplate.runnables.commands.TestCommand;

public class RedCraftPluginTemplate extends JavaPlugin {

  public RedCraftPluginTemplate() {
    super();
  }

  protected RedCraftPluginTemplate(
    JavaPluginLoader loader,
    PluginDescriptionFile description,
    File dataFolder,
    File file
  ) {
    super(loader, description, dataFolder, file);
  }

  private static RedCraftPluginTemplate instance;

  public static RedCraftPluginTemplate getInstance() {
    return instance;
  }

  @Override
  public void onEnable() {
    instance = this;

    // Setup
    Config.readConfig(this);
    DatabaseManager.connect();

    // Schedulers
    BukkitScheduler scheduler = getServer().getScheduler();

    // Game listeners
    PluginManager pluginManager = this.getServer().getPluginManager();

    // Commands
    this.getCommand("test").setExecutor(new TestCommand());
  }

  @Override
  public void onDisable() {
    getServer().getScheduler().cancelTasks(this);
  }
}
