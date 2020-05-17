package io.github.kingvictoria.commands;

import io.github.kingvictoria.NobilityRegions;
import io.github.kingvictoria.Region;
import io.github.kingvictoria.nodes.Node;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAddNode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ChatColor.RED + "This command can't be used from the console");
            return true;
        } // if

        Player player = (Player) commandSender;
        Region region = NobilityRegions.getRegionMaster().getRegion(player.getWorld(), player.getLocation().getBlock().getBiome());

        if(region == null) {
            commandSender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ERROR: " + ChatColor.RED + "This area is not a region");
            return true;
        } // if

        if(args.length == 2) {
        	String name = args[0];
        	String temp = args[1];
        	int slots = Integer.parseInt(temp);
            Node n = new Node(name,slots);
            NobilityRegions.getInstance().getNodeManager().addNode(region, n);
            commandSender.sendMessage(ChatColor.YELLOW + "Added Node to " + ChatColor.BLUE + "" + ChatColor.BOLD + region.getName() + ChatColor.YELLOW + " region");

        }else {
        	commandSender.sendMessage(ChatColor.DARK_RED + "Error invalid arguments. /command <name> <slots>");
        }
        

        

        return true;
    } // onCommand

} // class