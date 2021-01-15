package net.rod.sg.Commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.rod.sg.SG;

public class ChatColor
  implements CommandExecutor
{
  String prefix = "§8[§bScallex§8] ";
  public static final String RED = null;
  public static ArrayList<String> black = new ArrayList();
  public static ArrayList<String> cc = new ArrayList();
  public static ArrayList<String> dark_blue = new ArrayList();
  public static ArrayList<String> dark_green = new ArrayList();
  public static ArrayList<String> dark_aqua = new ArrayList();
  public static ArrayList<String> dark_red = new ArrayList();
  public static ArrayList<String> dark_purple = new ArrayList();
  public static ArrayList<String> gold = new ArrayList();
  public static ArrayList<String> gray = new ArrayList();
  public static ArrayList<String> dark_gray = new ArrayList();
  public static ArrayList<String> blue = new ArrayList();
  public static ArrayList<String> green = new ArrayList();
  public static ArrayList<String> aqua = new ArrayList();
  public static ArrayList<String> red = new ArrayList();
  public static ArrayList<String> light_purple = new ArrayList();
  public static ArrayList<String> yellow = new ArrayList();
  public static ArrayList<String> white = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("chatcolor"))
    {
      if (!(sender instanceof Player))
      {
        sender.sendMessage(SG.console);
        return true;
      }
      Player p = (Player)sender;
      if (p.hasPermission("cc.use"))
      {
        if (args.length == 0)
        {
          p.sendMessage(this.prefix + "§fYou have the following options§8:");
          p.sendMessage(this.prefix + "§c&c, §e&e, §b&b, §a&a, §fOFF§8.");
          p.sendMessage(this.prefix + "§f/chatcolor <ColorCode:OFF>");
        }
        else if (args.length == 1)
        {
          if (args[0].equalsIgnoreCase("&c"))
          {
            p.sendMessage(this.prefix + "§fYour chatcolor is now §cRed§8.");
            SG.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&c");
            SG.plugin.saveConfig();
          }
          else if (args[0].equalsIgnoreCase("&e"))
          {
            p.sendMessage(this.prefix + "§fYour chatcolor is now §eYellow§8.");
            SG.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&e");
            SG.plugin.saveConfig();
          }
          else if (args[0].equalsIgnoreCase("&b"))
          {
            p.sendMessage(this.prefix + "§fYour chatcolor is now §bAqua§8.");
            SG.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&b");
            SG.plugin.saveConfig();
          }
          else if (args[0].equalsIgnoreCase("&a"))
          {
            p.sendMessage(this.prefix + "§fYour chatcolor is now §aGreen§8.");
            SG.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&a");
            SG.plugin.saveConfig();
          }
          else if (args[0].equalsIgnoreCase("OFF"))
          {
            p.sendMessage(this.prefix + "§fYour chatcolor is now OFF§8.");
            SG.plugin.getConfig().set("ChatColor." + p.getUniqueId() + "." + p.getName() + ".ChatColor", "&r");
            SG.plugin.saveConfig();
          }
          else
          {
            p.sendMessage(this.prefix + "§fInvalid option§8: §7" + args[0] + "§8.");
          }
        }
        else
        {
          p.sendMessage(this.prefix + "§fYou have the following options§8:");
          p.sendMessage(this.prefix + "§c&c, §e&e, §b&b, §a&a, §fOFF§8.");
          p.sendMessage(this.prefix + "§f/chatcolor <ColorCode:OFF>");
        }
      }
      else {
        p.sendMessage(this.prefix + "§cYou don't have permission!");
      }
    }
    return false;
  }
}
