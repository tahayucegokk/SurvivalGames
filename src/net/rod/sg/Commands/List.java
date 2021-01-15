package net.rod.sg.Commands;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Segm.GameSegments;
import net.rod.sg.Segmentler.Cleanup;
import net.rod.sg.Segmentler.PreGame;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class List
implements CommandExecutor
{
public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
{
  Player p = (Player)sender;
  String prefix = PermissionsEx.getUser(p).getPrefix().replace('&', '§');
  if (cmd.getName().equalsIgnoreCase("list"))
  {
    p.sendMessage(SG.pr + "§fThere are §8[§e" + Bukkit.getOnlinePlayers().size() + "§7/§e24§8] §fonline players now§8!");
    if (Segm.getSegment() == Segm.GameSegments.LOBBY)
    {
      StringBuilder str = new StringBuilder();
      StringBuilder str2 = new StringBuilder();
      for (Player ps : Bukkit.getOnlinePlayers())
      {
        prefix = PermissionsEx.getUser(ps).getPrefix().replace('&', '§');
        if (str.length() > 0) {
          str.append(", ");
        }
        str.append(prefix + ps.getDisplayName() + "§r");
        
        String dn = ps.getDisplayName();
        if (Segm.getSegment() == Segm.GameSegments.LOBBY) {
            dn = ps.getDisplayName();
        } else {
            dn = ps.getDisplayName() + "§8(§c" + prefix + PreGame.ananame.get(ps) + "§8)";
        }
        if (str2.length() > 0) {
          str2.append(", ");
        }
        str2.append(prefix + dn + "§r");
      }
      if (p.hasPermission("staffchat.mod")) {
        p.sendMessage("§8- §f§lPlayers§8:§r " + str2.toString() + "§8.");
      } else {
        p.sendMessage("§8- §f§lPlayers§8:§r " + str.toString() + "§8.");
      }
    }
    else
    {
      StringBuilder str = new StringBuilder();
      StringBuilder str2 = new StringBuilder();
      
      StringBuilder str3 = new StringBuilder();
      StringBuilder str4 = new StringBuilder();
      for (Player ps : SG.tributes)
      {
        prefix = PermissionsEx.getUser(ps).getPrefix().replace('&', '§');
        if (str3.length() > 0) {
          str3.append(", ");
        }
        str3.append(prefix + ps.getDisplayName() + "§r");
        
        String dn = ps.getDisplayName();
        if (Segm.getSegment() == Segm.GameSegments.LOBBY) {
            dn = ps.getDisplayName();
        } else {
            dn = ps.getDisplayName() + "§8(§c" + prefix + PreGame.ananame.get(ps) + "§8)";
        }
        if (str4.length() > 0) {
          str4.append(", ");
        }
        str4.append(prefix + dn + "§r");
      }
      if (p.hasPermission("staffchat.mod")) {
        p.sendMessage("§8- §f§lPlaying§8:§r " + str4.toString() + "§8.");
      } else {
        p.sendMessage("§8- §f§lPlaying§8:§r " + str3.toString() + "§8.");
      }
      for (Player ps : SG.spectators)
      {
        prefix = PermissionsEx.getUser(ps).getPrefix().replace('&', '§');
        if (str.length() > 0) {
          str.append(", ");
        }
        str.append(prefix + ps.getDisplayName() + "§r");
        
        String dn = ps.getDisplayName();
        if (Segm.getSegment() == Segm.GameSegments.LOBBY) {
            dn = ps.getDisplayName();
        } else {
            dn = ps.getDisplayName() + "§8(§c" + prefix + PreGame.ananame.get(ps) + "§8)";
        }
        if (str2.length() > 0) {
          str2.append(", ");
        }
        str2.append(prefix + dn + "§r");
      }
      if (p.hasPermission("staffchat.mod")) {
        p.sendMessage("§8- §f§lWatching§8:§r " + str2.toString() + "§8.");
      } else {
        p.sendMessage("§8- §f§lWatching§8:§r " + str.toString() + "§8.");
      }
    }
  }
  return false;
}
}
