package net.rod.sg.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rod.sg.Utils.GameUtils;

public class Lobby
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("lobby")) {
      if (args.length == 0) {
        GameUtils.connectServer(p, "Lobby");
      }
    }
    return false;
  }
}
