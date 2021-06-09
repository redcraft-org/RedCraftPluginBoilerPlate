package org.redcraft.redcraftplugintemplate.runnables.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.redcraft.redcraftplugintemplate.RedCraftPluginTemplate;

public class TestCommand implements CommandExecutor {

  @Override
  public boolean onCommand(
    CommandSender sender,
    Command command,
    String label,
    String[] args
  ) {
    Bukkit.broadcastMessage("Test");
    return true;
  }
}
