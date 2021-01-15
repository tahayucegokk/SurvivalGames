package net.rod.sg.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rod.sg.SG;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SponsorCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("sponsor"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      String prefix = PermissionsEx.getUser(p).getPrefix().replace('&', '§');
      if (args.length == 0)
      {
        p.sendMessage("§fUsage: /sponsor <player>");
      }
      else if (args.length == 1)
      {
        Player t = Bukkit.getPlayer(args[0]);
        String prefix_t = PermissionsEx.getUser(t).getPrefix().replace('&', '§');
        if (t != null) {
          p.sendMessage(SG.pr + "§fYou have opened the sponsor menu for §2" + prefix_t + t.getDisplayName() + "§8!");
        }
      }
      else
      {
        p.sendMessage("§cInvalid arguments. Type /sponsor <player>");
      }
    }
    return false;
  }
}
