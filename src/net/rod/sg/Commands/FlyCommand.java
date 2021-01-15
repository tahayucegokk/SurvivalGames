package net.rod.sg.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Segm.GameSegments;

public class FlyCommand
  implements CommandExecutor
{
  public ArrayList<Player> fly = new ArrayList();
  static String noperm = "§cYou do not have permission for this command!";
  static String fly_on = "§fYou can now fly§8.";
  static String fly_off = "§fYou can no longer fly§8.";
  static String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Scallex" + ChatColor.DARK_GRAY + "]" + " ";
  
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("fly"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("fly.use"))
      {
        if (Segm.getSegment() == Segm.GameSegments.LOBBY) {
          if (args.length == 0)
          {
            if (!this.fly.contains(p))
            {
              this.fly.add(p);
              p.setAllowFlight(true);
              p.setFlying(true);
              p.sendMessage(prefix + fly_on);
            }
            else
            {
              this.fly.remove(p);
              p.setAllowFlight(false);
              p.setFlying(false);
              p.sendMessage(prefix + fly_off);
            }
          }
          else if (args.length == 1)
          {
            if (args[0].equalsIgnoreCase("on"))
            {
              p.setAllowFlight(true);
              p.setFlying(true);
              p.sendMessage(prefix + fly_on);
            }
            else if (args[0].equalsIgnoreCase("off"))
            {
              p.setAllowFlight(false);
              p.setFlying(false);
              p.sendMessage(prefix + fly_off);
            }
          }
          else if (args.length == 2)
          {
            Player t = Bukkit.getPlayer(args[1]);
            if (args[0].equalsIgnoreCase("on"))
            {
              t.setAllowFlight(true);
              t.setFlying(true);
              t.sendMessage(prefix + fly_on);
              p.sendMessage(prefix + "§a" + t.getName() + "§e's fly mode enabled");
            }
            else if (args[0].equalsIgnoreCase("off"))
            {
              t.setAllowFlight(false);
              t.setFlying(false);
              t.sendMessage(prefix + fly_off);
              p.sendMessage(prefix + "§a" + t.getName() + "§e's fly mode disabled");
            }
          }
        }
        else
        {
          p.sendMessage(prefix + "§cYou can't use this command Ingame§8!");
        }
      }
      else {
        p.sendMessage(prefix + "§cYou don't have permission for this command!");
      }
    }
    return false;
  }
}
