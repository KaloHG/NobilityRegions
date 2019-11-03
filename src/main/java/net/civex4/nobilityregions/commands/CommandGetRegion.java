package net.civex4.nobilityregions.commands;

import net.civex4.nobilityregions.NobilityRegions;
import net.civex4.nobilityregions.region.Region;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGetRegion implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
    if (!(commandSender instanceof Player)) {
      commandSender.sendMessage(ChatColor.RED + "This command can't be used from the console");
      return true;
    }

    Player player = (Player) commandSender;
    Region region = NobilityRegions.getRegionMaster().getRegion(player.getWorld(), player.getLocation().getBlock().getBiome());

    if (region == null) {
      commandSender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD
          + "ERROR: " + ChatColor.RED + "This area is not a Region");
      return true;
    }

    commandSender.sendMessage(ChatColor.YELLOW + "You are in the " + ChatColor.BLUE + ""
        + ChatColor.BOLD + region.getName() + ChatColor.YELLOW + " region");

    return true;
  }

}