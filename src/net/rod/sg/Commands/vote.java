package net.rod.sg.Commands;

import java.util.ArrayList;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Segm.GameSegments;
import net.rod.sg.Utils.VoteUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vote
  implements CommandExecutor
{
  public static int lobby = 0;
  public static int sg4 = 0;
  public static int alaskanvillage = 0;
  public static int turbulence = 0;
  public static int breezeisland2 = 0;
  public static int par72 = 0;
  public static int adrenaline = 0;
  public static int zone85 = 0;
  public static int demonsbreeze = 0;
  public static ArrayList<String> selectedvotes = new ArrayList();
  public static ArrayList<Player> usingvote = new ArrayList();
  
  public static void selectVotes() {}
  
  public void sendVoteMessage(Player p)
  {
    VoteUtils.sendV1(p);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("vote")) {
      if (Segm.getSegment() == Segm.GameSegments.LOBBY)
      {
        if (args.length == 0) {
          sendVoteMessage(p);
        } else if (args.length == 1) {
          if (args[0].equalsIgnoreCase("1"))
          {
            if (usingvote.contains(p))
            {
              p.sendMessage(SG.pr + "§4You have already using vote.");
            }
            else if (p.hasPermission("vote.owner"))
            {
              usingvote.add(p);
              int addvote = sg4 + 9;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.admin"))
            {
              usingvote.add(p);
              int addvote = sg4 + 8;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.srmoderator"))
            {
              usingvote.add(p);
              int addvote = sg4 + 7;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.moderator"))
            {
              usingvote.add(p);
              int addvote = sg4 + 6;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.mapmaker"))
            {
              usingvote.add(p);
              int addvote = sg4 + 5;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.vip"))
            {
              usingvote.add(p);
              int addvote = sg4 + 5;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.quantum"))
            {
              usingvote.add(p);
              int addvote = sg4 + 4;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.platinum"))
            {
              usingvote.add(p);
              int addvote = sg4 + 3;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.diamond"))
            {
              usingvote.add(p);
              int addvote = sg4 + 2;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.gold"))
            {
              usingvote.add(p);
              int addvote = sg4 + 2;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
            else
            {
              usingvote.add(p);
              int addvote = sg4 + 1;
              sg4 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + sg4 + "§8] §fvotes");
            }
          }
          else if (args[0].equalsIgnoreCase("2"))
          {
            if (usingvote.contains(p))
            {
              p.sendMessage(SG.pr + "§4You have already using vote.");
            }
            else if (p.hasPermission("vote.owner"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 9;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.admin"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 8;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.srmoderator"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 7;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.moderator"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 6;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.mapmaker"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 5;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.vip"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 5;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.quantum"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 4;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.platinum"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 3;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.diamond"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 2;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.gold"))
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 2;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
            else
            {
              usingvote.add(p);
              int addvote = alaskanvillage + 1;
              alaskanvillage = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
            }
          }
          else if (args[0].equalsIgnoreCase("3"))
          {
            if (usingvote.contains(p))
            {
              p.sendMessage(SG.pr + "§4You have already using vote.");
            }
            else if (p.hasPermission("vote.owner"))
            {
              usingvote.add(p);
              int addvote = turbulence + 9;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.admin"))
            {
              usingvote.add(p);
              int addvote = turbulence + 8;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.srmoderator"))
            {
              usingvote.add(p);
              int addvote = turbulence + 7;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.moderator"))
            {
              usingvote.add(p);
              int addvote = turbulence + 6;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.mapmaker"))
            {
              usingvote.add(p);
              int addvote = turbulence + 5;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.vip"))
            {
              usingvote.add(p);
              int addvote = turbulence + 5;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.quantum"))
            {
              usingvote.add(p);
              int addvote = turbulence + 4;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.platinum"))
            {
              usingvote.add(p);
              int addvote = turbulence + 3;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.diamond"))
            {
              usingvote.add(p);
              int addvote = turbulence + 2;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.gold"))
            {
              usingvote.add(p);
              int addvote = turbulence + 2;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
            else
            {
              usingvote.add(p);
              int addvote = turbulence + 1;
              turbulence = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + turbulence + "§8] §fvotes");
            }
          }
          else if (args[0].equalsIgnoreCase("4"))
          {
            if (usingvote.contains(p))
            {
              p.sendMessage(SG.pr + "§4You have already using vote.");
            }
            else if (p.hasPermission("vote.owner"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 9;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.admin"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 8;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.srmoderator"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 7;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.moderator"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 6;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.mapmaker"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 5;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.vip"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 5;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.quantum"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 4;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.platinum"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 3;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.diamond"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 2;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.gold"))
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 2;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
            else
            {
              usingvote.add(p);
              int addvote = breezeisland2 + 1;
              breezeisland2 = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
            }
          }
          else if (args[0].equalsIgnoreCase("5")) {
            if (usingvote.contains(p))
            {
              p.sendMessage(SG.pr + "§4You have already using vote.");
            }
            else if (p.hasPermission("vote.owner"))
            {
              usingvote.add(p);
              int addvote = lobby + 9;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.admin"))
            {
              usingvote.add(p);
              int addvote = lobby + 8;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.srmoderator"))
            {
              usingvote.add(p);
              int addvote = lobby + 7;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.moderator"))
            {
              usingvote.add(p);
              int addvote = lobby + 6;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.mapmaker"))
            {
              usingvote.add(p);
              int addvote = lobby + 5;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.vip"))
            {
              usingvote.add(p);
              int addvote = lobby + 5;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.quantum"))
            {
              usingvote.add(p);
              int addvote = lobby + 4;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.platinum"))
            {
              usingvote.add(p);
              int addvote = lobby + 3;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.diamond"))
            {
              usingvote.add(p);
              int addvote = lobby + 2;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else if (p.hasPermission("vote.gold"))
            {
              usingvote.add(p);
              int addvote = lobby + 2;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
            else
            {
              usingvote.add(p);
              int addvote = lobby + 1;
              lobby = addvote;
              p.sendMessage(SG.pr + "§fYour map now has §8[§6" + lobby + "§8] §fvotes");
            }
          }
        }
      }
      else {
        p.sendMessage(SG.pr + "§cVote is currently disabled right now!");
      }
    }
    return false;
  }
}
