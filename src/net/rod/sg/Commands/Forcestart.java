package net.rod.sg.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Segm.GameSegments;
import net.rod.sg.Utils.Teleporter;

public class Forcestart
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("forcestart"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player player = (Player)sender;
      if (player.hasPermission("shsg.forcestart")) {
        if (SG.forcestart)
        {
          player.sendMessage(SG.pr + "§cYou can't forcestart this game!");
        }
        else if (!SG.forcestart)
        {
          SG.forcestart = true;
          Bukkit.getServer().broadcastMessage(SG.pr + "§fThe game has been forcestarted by §2" + player.getDisplayName() + "§8!");
           Segm.setSegment(Segm.GameSegments.PREGAME);
        }
      }
      else  if (!player.hasPermission("shsg.forcestart")) {
    	  player.sendMessage("§8[§bScallex§8] §cYou do not have permission for this command§8!");
      }
    }
    return false;
  }
}
