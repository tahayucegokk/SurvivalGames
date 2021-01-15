package net.rod.sg;

import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.rod.sg.SG;
import net.rod.sg.Segmentler.Cleanup;
import net.rod.sg.Segmentler.DeathMatch;
import net.rod.sg.Segmentler.LiveGame;
import net.rod.sg.Segmentler.Lobby;
import net.rod.sg.Segmentler.PreDeathMatch;
import net.rod.sg.Segmentler.PreGame;

public class Segm
{
  public static GameSegments thissegment = GameSegments.NOTSELECTED;
  
  public static enum GameSegments
  {
    NOTSELECTED,  LOBBY,  PREGAME,  LIVEGAME,  PREDEATHMATCH,  DEATHMATCH,  ENDGAME,  CLEANUP;
  }
  
  public static void setSegment(GameSegments Segment)
  {
    thissegment = Segment;
    if (Segment == GameSegments.LOBBY)
    {
      MinecraftServer.getServer().setMotd("Lobby");
      SG.renk = "§a";
      SG.forcestart = false;
      Lobby.startLobbyCountdown();
    }
    else if (Segment == GameSegments.PREGAME)
    {
      MinecraftServer.getServer().setMotd("PreGame");
      SG.renk = "§6";
      PreGame.startPreGameCountdown();
    }
    else if (Segment == GameSegments.LIVEGAME)
    {
      MinecraftServer.getServer().setMotd("LiveGame");
      SG.renk = "§c";
      LiveGame.startLiveGameCountdown();
    }
    else if (Segment == GameSegments.PREDEATHMATCH)
    {
      MinecraftServer.getServer().setMotd("Pre-DeathMatch");
      SG.renk = "§5";
      PreDeathMatch.startPreDMCountdown();
    }
    else if (Segment == GameSegments.DEATHMATCH)
    {
      MinecraftServer.getServer().setMotd("DeathMatch");
      SG.renk = "§4";
      DeathMatch.startDeathMatchCountdown();
    }
    else if (Segment == GameSegments.CLEANUP)
    {
      MinecraftServer.getServer().setMotd("Restarting");
      SG.renk = "§7";
      Cleanup.restartGame();
    }
  }
  
  public static GameSegments getSegment()
  {
    return thissegment;
  }
}
