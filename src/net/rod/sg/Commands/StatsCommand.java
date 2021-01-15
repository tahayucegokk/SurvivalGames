package net.rod.sg.Commands;

import java.util.ArrayList;
import java.util.HashMap;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Listeners.JoinQuitListener;
import net.rod.sg.Segmentler.Cleanup;
import net.rod.sg.Utils.GameUtils;
import net.rod.sg.Utils.Stats;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class StatsCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("stats"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (args.length == 0)
      {
        long ticks = p.getStatistic(Statistic.PLAY_ONE_TICK);
        long anan = ticks / 25L;
        int deaths = Stats.getDeaths(p.getName()).intValue();
        int kills = Stats.getKills(p.getName()).intValue();
        int roundkills = Stats.getRkills(p.getName()).intValue();
        int chests = Stats.getChests(p.getName()).intValue();
        int roundchests = Stats.getRchests(p.getName()).intValue();
        String rank;
    
          rank = GameUtils.getRank(p);
          if ((Segm.getSegment() == Segm.GameSegments.LOBBY)) {
        PermissionGroup pex = PermissionsEx.getPermissionManager().getGroup(p.getName());
        
        p.sendMessage(SG.pr + "§2" + p.getDisplayName() + "§f's records");
        p.sendMessage(SG.pr + "§fRank§8: §e" + rank);
        p.sendMessage(SG.pr + "§fPoints§8: §e" + Stats.getBounty(p.getName()));
        p.sendMessage(SG.pr + "§fGame Rank§8: §8#§e" + JoinQuitListener.getPlayerNumber(p));
        p.sendMessage(SG.pr + "§fGames (Won/Total)§8: §e" + Stats.getWins(p.getName()) + "§8/§e" + Stats.getGames(p.getName()));
        p.sendMessage(SG.pr + "§fKills (Round/Total)§8: §e" + roundkills + "§8/§e" + kills);
        p.sendMessage(SG.pr + "§fChests (Round/Total)§8: §e" + roundchests + "§8/§e" + chests);
        p.sendMessage(SG.pr + "§fLifespan (Seconds)§8: §e" + anan + "s");
          }
          else {
        	  p.sendMessage(SG.pr + "§cYou cannot using this command to ingame§8!");
          }
          return true;
      }
      OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
      long ticks = p.getStatistic(Statistic.PLAY_ONE_TICK);
      long anan = ticks / 25L;
      int deaths = Stats.getDeaths(target.getName()).intValue();
      int kills = Stats.getKills(target.getName()).intValue();
      int roundkills = Stats.getRkills(target.getName()).intValue();
      int chests = Stats.getChests(target.getName()).intValue();
      int roundchests = Stats.getRchests(target.getName()).intValue();
      String rank;
 
        rank = GameUtils.getRank(target);
      
      p.sendMessage(SG.pr + "§2" + target.getName() + "§f's records");
      p.sendMessage(SG.pr + "§fRank§8: §e" + rank);
      p.sendMessage(SG.pr + "§fPoints§8: §e" + Stats.getBounty(target.getName()));
      if ((JoinQuitListener.getPlayerNumber(target) == null) || (!target.isOnline())) {
        p.sendMessage(SG.pr + "§fGame Rank§8: §cN/A");
      } else {
        p.sendMessage(SG.pr + "§fGame Rank§8: §8#§e" + JoinQuitListener.getPlayerNumber(target));
      }
      p.sendMessage(SG.pr + "§fGames (Won/Total)§8: §e" + Stats.getWins(target.getName()) + "§8/§e" + Stats.getGames(target.getName()));
      p.sendMessage(SG.pr + "§fKills (Round/Total)§8: §e" + roundkills + "§8/§e" + kills);
      p.sendMessage(SG.pr + "§fChests (Round/Total)§8: §e" + roundchests + "§8/§e" + chests);
      if (!target.isOnline()) {
        p.sendMessage(SG.pr + "§fLifespan (Seconds)§8: §cN/A");
      } else {
        p.sendMessage(SG.pr + "§fLifespan (Seconds)§8: §e" + anan + "s");
      }
    }
    return false;
  }
}
