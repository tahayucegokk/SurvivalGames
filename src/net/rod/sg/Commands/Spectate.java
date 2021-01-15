package net.rod.sg.Commands;

import java.util.ArrayList;

import net.rod.sg.SG;
import net.rod.sg.Utils.GameUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spectate
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("spectate"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (args.length == 0)
      {
        p.sendMessage(SG.pr + "§cUsage: /spectate <player>");
      }
      else if (args.length == 1)
      {
        Player t = Bukkit.getPlayer(args[0]);
        if (SG.spectators.contains(p))
        {
          if (SG.tributes.contains(t))
          {
            GameUtils.enableSpec(p);
            p.teleport(t.getLocation());
            p.sendMessage(SG.pr + "§fYou teleported to §2" + t.getDisplayName());
          }
          else if (SG.spectators.contains(t))
          {
            p.sendMessage(SG.pr + "§cYou can't teleport the spectators§8!");
          }
          else if (t == null)
          {
            p.sendMessage(SG.pr + "§cPlayer is not online§8!");
          }
        }
        else {
          p.sendMessage(SG.pr + "§cYou are not spectator§8!");
        }
      }
    }
    return false;
  }
}
