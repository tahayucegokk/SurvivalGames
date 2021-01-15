package net.rod.sg.Commands;

import net.rod.sg.SG;
import net.rod.sg.Utils.GameUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setLobby
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("setlobby"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("Xera.setlobby"))
      {
        GameUtils.setLobby(p);
        p.sendMessage(SG.pr + "§aWaiting lobby has been set§8!");
      }
      else
      {
        p.sendMessage("§cYou don't have permission for this command!");
      }
    }
    return false;
  }
}
