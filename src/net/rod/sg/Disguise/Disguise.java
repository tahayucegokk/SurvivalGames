package net.rod.sg.Disguise;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo.EnumPlayerInfoAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.rod.sg.SG;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Disguise
 implements Listener
{
  public static HashMap<Player, String> ananame = new HashMap();
  public static HashMap<Player, String> anaskin = new HashMap();
  
  
  public void onDisable()
  {
    System.out.println("[DISGUISE] PLUGIN DISABLED!");
  }
  
  @EventHandler
  public void onPlayerJoinEvent(PlayerJoinEvent e)
  {
    Player o = e.getPlayer();
    ananame.put(o, o.getName());
    anaskin.put(o, o.getName());
  }
  

  
 
  private Field nameField;
  
 
  
  private void removeFromTab(CraftPlayer cp)
  {
    PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, new EntityPlayer[] { cp.getHandle() });
    sendPacket(packet);
  }
  
  private void addToTab(CraftPlayer cp)
  {
    PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, new EntityPlayer[] { cp.getHandle() });
    sendPacket(packet);
  }
  
  private void sendPacket(Packet<?> packet)
  {
    for (Player all : Bukkit.getOnlinePlayers() ) {
      ((CraftPlayer)all).getHandle().playerConnection.sendPacket(packet);
    }
  }
  
  private Field getField(Class<?> clazz, String name)
  {
    try
    {
      Field field = clazz.getDeclaredField(name);
      field.setAccessible(true);
      return field;
    }
    catch (NoSuchFieldException|SecurityException e) {}
    return null;
  

  }
  public void setname(Player o)
  {
    List r_taunt =  SG.plugin.getConfig().getStringList("ak1");
    
    Random rand = new Random();
    int choice = rand.nextInt(r_taunt.size());
    
    List ak2 =  SG.plugin.getConfig().getStringList("ak2");
    Random rand1 = new Random();
    int choice1 = rand1.nextInt(ak2.size());
    List ak3 =  SG.plugin.getConfig().getStringList("ak3");
    Random rand2 = new Random();
    int choice2 = rand2.nextInt(ak3.size());
    List skin =  SG.plugin.getConfig().getStringList("skins");
    
    Random randskin = new Random();
    int choiceskin = randskin.nextInt(skin.size());
    String skinsec = (String)skin.get(choiceskin);
    Random random = new Random();
    int sans1 = random.nextInt(2);
    if (sans1 == 1)
    {
      List list =  SG.plugin.getConfig().getStringList("dk");
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      String kayit = o.getName() + "-->" + (String)r_taunt.get(choice) + (String)ak2.get(choice1) + (String)ak3.get(choice2) + " " + dateFormat.format(date);
      List dkm =  SG.plugin.getConfig().getStringList("dk");
       SG.plugin.getConfig().createSection(kayit);
      String prefix =  SG.plugin.getConfig().getString("prefix").replace("&", "§");
      o.setDisplayName((String)r_taunt.get(choice) + (String)ak2.get(choice1) + (String)ak3.get(choice2));
      o.setPlayerListName("§2" + (String)r_taunt.get(choice) + (String)ak2.get(choice1) + (String)ak3.get(choice2));
       SG.plugin.nameset(o, (String)r_taunt.get(choice) + (String)ak2.get(choice1) + (String)ak3.get(choice2));
       SG.plugin.skinset(o, skinsec);
      o.setPlayerListName("§2" + (String)r_taunt.get(choice) + (String)ak2.get(choice1) + (String)ak3.get(choice2));
       SG.plugin.saveConfig();
    }
    else if (sans1 == 0)
    {
      List dkm =  SG.plugin.getConfig().getStringList("dk");
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      Date date = new Date();
      String kayit = o.getName() + "-->" + (String)r_taunt.get(choice) + (String)ak2.get(choice1) + " " + dateFormat.format(date);
      
      SG.plugin.getConfig().createSection(kayit);
      String prefix =  SG.plugin.getConfig().getString("prefix").replace("&", "§");
      o.setDisplayName((String)r_taunt.get(choice) + (String)ak2.get(choice1));
      o.setPlayerListName("§2" + (String)r_taunt.get(choice) + (String)ak2.get(choice1));
      SG.plugin.nameset(o, (String)r_taunt.get(choice) + (String)ak2.get(choice1));
      SG.plugin.skinset(o, skinsec);
      o.setPlayerListName("§2" + (String)r_taunt.get(choice) + (String)ak2.get(choice1));
       SG.plugin.saveConfig();
    }
  }
}