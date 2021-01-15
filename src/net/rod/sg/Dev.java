package net.rod.sg;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Dev
  implements Listener
{
	public static String getRainbowName(String name) {
		  String[] colours = new String[]{"§4", "§c", "§6", "§e", "§a", "§2", "§b", "§3", "§9", "§1", "§5", "§d"};
		  int x = 0;
		  StringBuilder str = new StringBuilder();
		  for (char c : name.toCharArray()) {
			  if (x < colours.length) {
				  str.append(colours[x] + "§l" + c);
				  x++;
			  }else {
				  x = 0;
			  }
		  }
		  return str.toString();
	  }
	
  public static void devnick(Player player)
  {
 if (!player.isOp()) {
     if (player.hasPermission("xime.developer")) {
      
        player.setDisplayName(getRainbowName(player.getName()));
        player.setPlayerListName(getRainbowName(player.getName()));
      }
    if (player.hasPermission("xime.owner"))
    {
      String nick = "§4§l" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.admin"))
    {
      String nick = "§4§l" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.moderator"))
    {
      String nick = "§c" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.SrModerator"))
    {
      String nick = "§4" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.vip"))
    {
      String nick = "§5" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.gold"))
    {
      String nick = "§6" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.diamond"))
    {
      String nick = "§3" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.plat"))
    {
      String nick = "§b" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.TrialModerator"))
    {
      String nick = "§c" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.qua"))
    {
      String nick = "§a" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.builder"))
    {
      String nick = "§d" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
    if (player.hasPermission("xime.regular"))
    {
      String nick = "§2" + player.getName();
      player.setDisplayName(nick);
      player.setPlayerListName(nick);
    }
 }
 else if (player.isOp()) {
     String nick = "§4§l" + player.getName();
     player.setDisplayName(nick);
     player.setPlayerListName(nick);
     }
 else if (!player.isOp()) {
 	  String nick = "§2" + player.getName();
     player.setDisplayName(nick);
       player.setPlayerListName(nick);
 }
 }
  @EventHandler
  public void Joins(PlayerJoinEvent e)
  {
    Player player = e.getPlayer();
    if (!player.isOp()) {
    	  String nick = "§2" + player.getName();
          player.setDisplayName(nick);
          player.setPlayerListName(nick);
    }
  }
  
  @EventHandler
  public void Join(PlayerJoinEvent e)
  {
    Player player = e.getPlayer();
    if (!player.isOp()) {
        if (player.hasPermission("xime.developer")) {
         
           player.setDisplayName(getRainbowName(player.getName()));
           player.setPlayerListName(getRainbowName(player.getName()));
         }
       if (player.hasPermission("xime.owner"))
       {
         String nick = "§4§l" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.admin"))
       {
         String nick = "§4§l" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.moderator"))
       {
         String nick = "§c" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.SrModerator"))
       {
         String nick = "§4" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.vip"))
       {
         String nick = "§5" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.gold"))
       {
         String nick = "§6" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.diamond"))
       {
         String nick = "§3" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.plat"))
       {
         String nick = "§b" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.TrialModerator"))
       {
         String nick = "§c" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.qua"))
       {
         String nick = "§a" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.builder"))
       {
         String nick = "§d" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
       if (player.hasPermission("xime.regular"))
       {
         String nick = "§2" + player.getName();
         player.setDisplayName(nick);
         player.setPlayerListName(nick);
       }
    }
    else if (player.isOp()) {
        String nick = getRainbowName(player.getName());
        player.setDisplayName(getRainbowName(player.getName()));
        player.setPlayerListName(getRainbowName(player.getName()));
        }
    if (!player.isOp()) {
    	  String nick = "§2" + player.getName();
        player.setDisplayName(nick);
          player.setPlayerListName(nick);
    }
    }
}
