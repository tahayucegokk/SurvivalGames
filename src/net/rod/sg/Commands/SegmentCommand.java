package net.rod.sg.Commands;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Segm.GameSegments;
import net.rod.sg.Segmentler.Cleanup;
import net.rod.sg.Segmentler.DeathMatch;
import net.rod.sg.Segmentler.EndGame;
import net.rod.sg.Segmentler.LiveGame;
import net.rod.sg.Segmentler.Lobby;
import net.rod.sg.Segmentler.PreDeathMatch;
import net.rod.sg.Segmentler.PreGame;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class SegmentCommand
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("segment")) {
      if (p.hasPermission("sg.segment"))
      {
        if (args.length == 0) {
          p.sendMessage(SG.pr + "§cUsage: /segment §4<Game_Segment>");
        } else if (args.length == 1)
        {
          if ((args[0].equalsIgnoreCase("deathmatch")) || (args[0].equalsIgnoreCase("dm")))
          {
            Bukkit.getScheduler().cancelTask(Lobby.LobbyTask);
            Bukkit.getScheduler().cancelTask(LiveGame.LiveGameTask);
            Bukkit.getScheduler().cancelTask(PreGame.PreGameTask);
            Bukkit.getScheduler().cancelTask(PreDeathMatch.PreDMTask);
            Bukkit.getScheduler().cancelTask(Cleanup.RestartTask);
            Bukkit.getScheduler().cancelTask(DeathMatch.DeathMatchTask);
            Bukkit.getScheduler().cancelTask(EndGame.EndGameTask);
            Segm.setSegment(Segm.GameSegments.DEATHMATCH);
            Bukkit.broadcastMessage(SG.pr + "§fThe segment has been changed to Deathmatch by§2" + p.getDisplayName());
          }
          else if ((args[0].equalsIgnoreCase("predeathmatch")) || (args[0].equalsIgnoreCase("predm")))
          {
            Bukkit.getScheduler().cancelTask(Lobby.LobbyTask);
            Bukkit.getScheduler().cancelTask(LiveGame.LiveGameTask);
            Bukkit.getScheduler().cancelTask(PreGame.PreGameTask);
            Bukkit.getScheduler().cancelTask(PreDeathMatch.PreDMTask);
            Bukkit.getScheduler().cancelTask(DeathMatch.DeathMatchTask);
            Bukkit.getScheduler().cancelTask(Cleanup.RestartTask);
            Bukkit.getScheduler().cancelTask(EndGame.EndGameTask);
            Segm.setSegment(Segm.GameSegments.PREDEATHMATCH);
            Bukkit.broadcastMessage(SG.pr + "§fThe segment has been changed to PreDeathmatch by " + p.getDisplayName());
          }
          else if ((args[0].equalsIgnoreCase("lobby")) || (args[0].equalsIgnoreCase("lb")))
          {
            Bukkit.getScheduler().cancelTask(LiveGame.LiveGameTask);
            Bukkit.getScheduler().cancelTask(PreGame.PreGameTask);
            Bukkit.getScheduler().cancelTask(PreDeathMatch.PreDMTask);
            Bukkit.getScheduler().cancelTask(Lobby.LobbyTask);
            Bukkit.getScheduler().cancelTask(Cleanup.RestartTask);
            Bukkit.getScheduler().cancelTask(EndGame.EndGameTask);
            Bukkit.getScheduler().cancelTask(DeathMatch.DeathMatchTask);
            Segm.setSegment(Segm.GameSegments.LOBBY);
            Bukkit.broadcastMessage(SG.pr + "§fThe segment has been changed to Lobby by " + p.getDisplayName());
          }
          else if ((args[0].equalsIgnoreCase("pregame")) || (args[0].equalsIgnoreCase("pg")))
          {
            Bukkit.getScheduler().cancelTask(Lobby.LobbyTask);
            Bukkit.getScheduler().cancelTask(LiveGame.LiveGameTask);
            Bukkit.getScheduler().cancelTask(PreDeathMatch.PreDMTask);
            Bukkit.getScheduler().cancelTask(Cleanup.RestartTask);
            Bukkit.getScheduler().cancelTask(EndGame.EndGameTask);
            Bukkit.getScheduler().cancelTask(DeathMatch.DeathMatchTask);
            Segm.setSegment(Segm.GameSegments.PREGAME);
            Bukkit.broadcastMessage(SG.pr + "§fThe segment has been changed to PreGame by " + p.getDisplayName());
          }
          else if ((args[0].equalsIgnoreCase("livegame")) || (args[0].equalsIgnoreCase("lg")))
          {
            Bukkit.getScheduler().cancelTask(Lobby.LobbyTask);
            Bukkit.getScheduler().cancelTask(PreGame.PreGameTask);
            Bukkit.getScheduler().cancelTask(LiveGame.LiveGameTask);
            Bukkit.getScheduler().cancelTask(PreDeathMatch.PreDMTask);
            Bukkit.getScheduler().cancelTask(Cleanup.RestartTask);
            Bukkit.getScheduler().cancelTask(EndGame.EndGameTask);
            Bukkit.getScheduler().cancelTask(DeathMatch.DeathMatchTask);
            Segm.setSegment(Segm.GameSegments.LIVEGAME);
            Bukkit.broadcastMessage(SG.pr + "§fThe segment has been changed to LiveGame by " + p.getDisplayName());
          }
          else if ((args[0].equalsIgnoreCase("cleanup")) || (args[0].equalsIgnoreCase("cp")))
          {
            Bukkit.getScheduler().cancelTask(Lobby.LobbyTask);
            Bukkit.getScheduler().cancelTask(LiveGame.LiveGameTask);
            Bukkit.getScheduler().cancelTask(PreGame.PreGameTask);
            Bukkit.getScheduler().cancelTask(PreDeathMatch.PreDMTask);
            Bukkit.getScheduler().cancelTask(Cleanup.RestartTask);
            Bukkit.getScheduler().cancelTask(EndGame.EndGameTask);
            Bukkit.getScheduler().cancelTask(DeathMatch.DeathMatchTask);
            Segm.setSegment(Segm.GameSegments.CLEANUP);
            Bukkit.broadcastMessage(SG.pr + "§fThe segment has been changed to Cleanup by " + p.getDisplayName());
          }
          else if (args[0].equalsIgnoreCase("list"))
          {
            p.sendMessage("§8- §f§lSegments§8: §aLOBBY§8, §6PREGAME§8, §CLIVEGAME§8, §5PREDEATHMATCH§8, §4DEATHMATCH§8, §7CLEANUP§8.");
          }
          else
          {
            p.sendMessage("§cInvalid game segment! Type '/segment list' for list!");
          }
        }
        else {
          p.sendMessage("§cInvalid arguments. Type /segment <Game_Segment>");
        }
      }
      else {
        p.sendMessage("§cYou don't have permission for this command!");
      }
    }
    return false;
  }
}
