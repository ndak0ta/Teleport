package com.minecraft.plugins.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Teleport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "You must specify a player!");
                return false;
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Player not found!");
                    return false;
                }

                player.teleport(target.getLocation());
                target.sendMessage(ChatColor.GREEN + player.getName() + "Teleported to you!");
            }

        } else {
            sender.sendMessage("You must be a player!");
        }

        return true;
    }
}
