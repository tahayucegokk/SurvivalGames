package net.rod.sg.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rod.sg.SG;
import net.rod.sg.Segm;
import net.rod.sg.Listeners.JoinQuitListener;
import net.rod.sg.Segmentler.LiveGame;
import net.rod.sg.Utils.Teleporter;
import net.rod.sg.Utils.VoteUtils;

public class Test  implements CommandExecutor
{
	  String prefix = "§8[§bScallex§8] ";
	 
	  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
	    if (cmd.getName().equalsIgnoreCase("test"))
	    {
	      if (!(sender instanceof Player))
	      {
	        sender.sendMessage("Complated");
	        Segm.setSegment(Segm.GameSegments.PREGAME);
	        return true;
	      }
	      Player p = (Player)sender;
	     p.sendMessage(VoteUtils.selectmap+","+String.valueOf(JoinQuitListener.getPlayerNumber(p))+","+ vote.selectedvotes.toString().replace("[", "").replace("]", ""));
	     
	     LiveGame.LiveGameTime=1090;
	    }
	    return false;
	  }
	}
