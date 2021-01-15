package net.rod.sg.Commands;

import java.util.ArrayList;
import java.util.HashMap;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Listeners.EVENT_Board;
import net.rod.sg.Segm.GameSegments;
import net.rod.sg.Utils.Stats;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bounty
  implements CommandExecutor
{
  public static HashMap<Player, Integer> puan = new HashMap();
  public static HashMap<Player, Player> puan2 = new HashMap();
  
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
  
    if (cmd.getName().equalsIgnoreCase("resetbounty"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("bounty.reset"))
      {
        if (args.length == 0)
        {
          p.sendMessage("§cUsage: /resetbounty <player> [amount]");
        }
        else if (args.length == 1)
        {
          Player t = Bukkit.getPlayer(args[0]);
          if (t.getName() == null)
          {
            p.sendMessage(SG.pr + "§cPlayer is not found");
          }
          else
          {
            Stats.setBounty(t.getName(), 100);
            p.sendMessage(SG.pr + "§2" + t.getDisplayName() + "§3's points reseted!");
            t.sendMessage(SG.pr + "§3Your points reseted §3by §2" + p.getDisplayName());
          }
        }
        else
        {
          p.sendMessage("§cInvalid arguments. Type /setbounty <player> [amount]");
        }
      }
      else {
        p.sendMessage(SG.pr + SG.noperm);
      }
    }
    if (cmd.getName().equalsIgnoreCase("setbounty"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("bounty.set"))
      {
        if (args.length == 0)
        {
          p.sendMessage(SG.pr + "§cUsage: /setbounty <player> [amount]");
        }
        else if (args.length == 1)
        {
          p.sendMessage("§cPlease enter an amount!");
        }
        else if (args.length == 2)
        {
          Player t = Bukkit.getPlayer(args[0]);
          int bounty = Integer.parseInt(args[1]);
          if (t.getName() == null)
          {
            p.sendMessage(SG.pr + "§cPlayer is not found");
          }
          else
          {
            Stats.setBounty(t.getName(), bounty);
            p.sendMessage(SG.pr + "§2" + t.getDisplayName() + "§3's points set to §8[§e" + bounty + "§8]");
            t.sendMessage(SG.pr + "§3Your points set to §8[§e" + bounty + "§8] §3by §2" + p.getDisplayName());
          }
        }
        else
        {
            p.sendMessage(SG.pr + "§cUsage: /setbounty <player> <amount>");
        }
      }
      else {
        p.sendMessage(SG.pr + SG.noperm);
      }
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("bounty")) {
      if (args.length == 0)
      {
    	    if (Segm.getSegment() == Segm.GameSegments.LOBBY)
            {
              p.sendMessage(SG.pr + "§4You must be a spectator to use this command§8!");
            }
            else if (SG.tributes.contains(p))
            {
              p.sendMessage(SG.pr + "§4You must be a spectator to use this command§8!");
            }
          else if (Segm.getSegment() != Segm.GameSegments.LOBBY) {
              p.sendMessage(SG.pr + "§cUsage: /bounty <player> <amount>");
          }
      }
      else if (args.length == 1)
      {
          if (Segm.getSegment() == Segm.GameSegments.LOBBY)
          {
            p.sendMessage(SG.pr + "§4You must be a spectator to use this command§8!");
          }
          else if (SG.tributes.contains(p))
          {
            p.sendMessage(SG.pr + "§4You must be a spectator to use this command§8!");
          }
          else if (Segm.getSegment() != Segm.GameSegments.LOBBY) {
              Player t = Bukkit.getPlayer(args[0]);
        p.sendMessage(SG.pr + "§cUsage: /bounty <player> <amount>");
          }
      }
      else if (args.length == 2)
      {
  	    if (Segm.getSegment() == Segm.GameSegments.LOBBY)
        {
          p.sendMessage(SG.pr + "§4You must be a spectator to use this command§8!");
        }
        else if (SG.tributes.contains(p))
        {
          p.sendMessage(SG.pr + "§4You must be a spectator to use this command§8!");
        }
          else if (Segm.getSegment() != Segm.GameSegments.LOBBY) {
        Player t = Bukkit.getPlayer(args[0]);
        int bounty = Integer.parseInt(args[1]);
        int pbounty = Stats.getBounty(p.getName()).intValue();
        if (SG.spectators.contains(t)) {
            p.sendMessage(SG.pr +"§4You can not send points to spectators§8!");
          }
        if (t != null)
        {
          if (t.getName() != p.getName())
          {
            if (bounty < 500)
            {
              if (bounty > 10)
              {
                if (bounty <= pbounty)
                {
                  Stats.addBounty(t.getName(), bounty);
                  Stats.removeBounty(p.getName(), bounty);
                  Bukkit.broadcastMessage(SG.pr + "§3Bounty has been set on §2" + p.getName() + "§3 of §2" + t.getName() + "§3 for §8[§e" + bounty + "§8] §3points§8.");
                }
                else
                {
                    p.sendMessage(SG.pr + "§4You do not have enough points!");
                }
              }
              else {
                  p.sendMessage(SG.pr + "§cBounties must be higher than §8[§e10§8] §cpoints§8.");
              }
            }
            else {
            	 p.sendMessage(SG.pr + "§cBounties must be lower than §8[§e500§8] §cpoints§8.");
            }
          }
          else {
              p.sendMessage(SG.pr + "§4You can not send points to yourself!");
          }
        }
        else {
            p.sendMessage(SG.pr + "§cPlayer is not found!");
        }
          }
      }
    }
	return false;
  }
}

