package net.rod.sg.Commands;

import net.rod.sg.SG;
import net.rod.sg.Utils.GameUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setSpec
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("setspec"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("minesg.setspec"))
      {
        if (args.length == 0) {
          p.sendMessage("§cUsage: /setspec <Map>");
        } else if (args.length == 1) {
          GameUtils.setSpec(p, args[0]);
        }
      }
      else {
        p.sendMessage("§cYou don't have permission for this command!");
      }
    }
    return false;
  }
}
