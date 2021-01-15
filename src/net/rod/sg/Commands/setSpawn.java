package net.rod.sg.Commands;

import net.rod.sg.SG;
import net.rod.sg.Utils.GameUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setSpawn
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("setspawn"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("sg.setspawn"))
      {
        if (args.length == 0) {
          p.sendMessage(SG.pr + "§cUsage: /setspawn <map> <spawnpoint>");
        } else if (args.length == 1) {
          p.sendMessage("§cPlease enter spawnpoint!");
        } else if (args.length == 3) {
          GameUtils.addLocation(p, args[0], args[1], args[2]);
        } else {
          p.sendMessage("§cInvalid arguments. Type /setspawn <map> <spawnpoint>");
        }
      }
      else {
        p.sendMessage("§cYou don't have permission for this command!");
      }
    }
    return false;
  }
}
