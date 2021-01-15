package net.rod.sg.Commands;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import net.rod.sg.Listeners.EVENT_Board;
import net.rod.sg.Listeners.InteractListener;

public class SG
  implements CommandExecutor
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
  public static ItemStack sword;
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
	if (cmd.getName().equalsIgnoreCase("addvote")) {
    Player ps = (Player)sender;
    if (args.length == 0) {
    	 if (ps.hasPermission("Scallex.admin")) {
        ps.sendMessage(net.rod.sg.SG.pr + "§cUsage: /addvote <map>");
    	 }
    	 else {
    		 ps.sendMessage(net.rod.sg.SG.pr + net.rod.sg.SG.noperm);
    	 }
      }
       else if (args[0].equalsIgnoreCase("sg4"))
	        {
	          if (ps.hasPermission("Scallex.admin")) {
	        	  int addvote = vote.sg4 + 100;
	                vote.sg4 = addvote;
	                ps.sendMessage(net.rod.sg.SG.pr +"§7You are succesfuly §aadd §6SG4 §7votes.");
	          }
	        }
           else if (args[0].equalsIgnoreCase("par72"))
		        {
		          if (ps.hasPermission("Scallex.admin")) {
		        	  int addvote = vote.lobby + 100;
		                vote.lobby = addvote;
		                ps.sendMessage(net.rod.sg.SG.pr +"§7You are succesfuly §aadd §6Par72 §7votes.");
		          }
		        }
		          else if (args[0].equalsIgnoreCase("turbulence"))
			        {
			          if (ps.hasPermission("Scallex.admin")) {
			        	  int addvote = vote.turbulence + 100;
			                vote.turbulence = addvote;
			                ps.sendMessage(net.rod.sg.SG.pr +"§7You are succesfuly §aadd §6Turbulence §7votes.");
			          }
			        }
			          else if (args[0].equalsIgnoreCase("alaskan"))
				        {
				          if (ps.hasPermission("Scallex.admin")) {
				        	  int addvote = vote.alaskanvillage + 100;
				                vote.alaskanvillage = addvote;
				                ps.sendMessage(net.rod.sg.SG.pr +"§7You are succesfuly §aadd §6Alaskan Village §7votes.");
				          }
				          }
				          else if (args[0].equalsIgnoreCase("breeze"))
					        {
					          if (ps.hasPermission("Scallex.admin")) {
					        	  int addvote = vote.breezeisland2 + 100;
					                vote.breezeisland2 = addvote;
					                ps.sendMessage(net.rod.sg.SG.pr +"§7You are succesfuly §aadd §6Breeze Island 2 §7votes.");
					          }
					        }
	  }
    if (cmd.getName().equalsIgnoreCase("sg"))
    {
      if (!(sender instanceof Player))
      {

        Bukkit.getConsoleSender().sendMessage("§8████████████████████████");
        Bukkit.getConsoleSender().sendMessage("§3§lScallex §fSystem V1 is running§8.");
        Bukkit.getConsoleSender().sendMessage("§8» §fSegment: §bSurvivalGames");
        Bukkit.getConsoleSender().sendMessage("§8» §fSystem Type: §bJavaPlugin");
        Bukkit.getConsoleSender().sendMessage("§8» §fGeneral Type: §bR0.1-SNAPSHOT");
        Bukkit.getConsoleSender().sendMessage("§8» §fSystem Info:" + getRainbowName("foraup"));
        Bukkit.getConsoleSender().sendMessage("§8████████████████████████");

        return true;
      }
      Player p = (Player)sender;
      if (args.length == 0) {
        get(p);
      } else if (args.length == 1)
      {
        if (args[0].equalsIgnoreCase("spec"))
        {
          if (p.hasPermission("Scallex.admin")) {
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage("§8[§6SoloSG§8] §cYou are joined to spectator if do you un spec please use §8[§6/sg unspec§8]");
          }
        }
        else if (args[0].equalsIgnoreCase("unspec"))
        {
          if (p.hasPermission("Scallex.admin")) {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage("§8[§6SoloSG§8] §aYou have been unspected");
          }
        }
        else if (args[0].equalsIgnoreCase("refill"))
        {
          if (p.hasPermission("Scallex.Refill")) {
        	
        	p.sendMessage("§8[§6SoloSG§8] §aCongrats! §7All chest refilled§8.");
        	  InteractListener.setupChests();

          }
        }
        else if (args[0].equalsIgnoreCase("resetvotes"))
        {
          if (p.hasPermission("Scallex.ResetVotes"))
          {
            vote.usingvote.clear();
            vote.lobby = 0;
            vote.sg4 = 0;
            vote.alaskanvillage = 0;
            vote.turbulence = 0;
            vote.breezeisland2 = 0;
            vote.par72 = 0;
            vote.adrenaline = 0;
            vote.zone85 = 0;
            vote.demonsbreeze = 0;
            vote.selectedvotes.clear();
            p.sendMessage(net.rod.sg.SG.pr + "§aAll votes are cleared");
          }
        }
        else if (args[0].equalsIgnoreCase("min"))
        {
          net.rod.sg.SG.sidebar.remove(p);
          net.rod.sg.SG.sidebar.add(p);
          EVENT_Board.minimize(p);
        }
        else if (args[0].equalsIgnoreCase("max"))
        {
          net.rod.sg.SG.sidebar.remove(p);
          EVENT_Board.show(p);
        }
        else
        {
          get(p);
        }
      }
      else {
        get(p);
               }

  }
	return false;
  }
 
		        
		          
  
  public void get(Player p)
  {
    p.sendMessage("§8████████████████████████");
    p.sendMessage("§3§lScallex §fSystem V1 is running§8.");
    p.sendMessage("§8» §fSegment: §bSurvivalGames");
    p.sendMessage("§8» §fSystem Type: §bJavaPlugin");
    p.sendMessage("§8» §fGeneral Type: §bR0.1-SNAPSHOT");
    p.sendMessage("§8» §fSystem Info: " + getRainbowName("foraup"));
    p.sendMessage("§8████████████████████████");
  }
}