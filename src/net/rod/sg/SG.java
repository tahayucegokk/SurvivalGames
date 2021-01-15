package net.rod.sg;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.Main;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.rod.sg.Commands.Bounty;
import net.rod.sg.Commands.FlyCommand;
import net.rod.sg.Commands.Forcestart;
import net.rod.sg.Commands.Lobby;
import net.rod.sg.Commands.SegmentCommand;
import net.rod.sg.Commands.Spectate;
import net.rod.sg.Commands.StatsCommand;
import net.rod.sg.Commands.Test;
import net.rod.sg.Commands.setLobby;
import net.rod.sg.Commands.setSpawn;
import net.rod.sg.Commands.setSpec;
import net.rod.sg.Commands.vote;
import net.rod.sg.Disguise.Disguise;
import net.rod.sg.Disguise.Events;
import net.rod.sg.Disguise.Skin;
import net.rod.sg.Listeners.Achievement;
import net.rod.sg.Listeners.BuildListener;
import net.rod.sg.Listeners.ChatListener;
import net.rod.sg.Listeners.ChestListener;
import net.rod.sg.Listeners.DamageListener;
import net.rod.sg.Listeners.DeathListener;
import net.rod.sg.Listeners.EVENT_Board;
import net.rod.sg.Listeners.FoodLevelListener;
import net.rod.sg.Listeners.InteractListener;
import net.rod.sg.Listeners.JoinQuitListener;
import net.rod.sg.Listeners.MobListener;
import net.rod.sg.Listeners.MotdListener;
import net.rod.sg.Listeners.MoveListener;
import net.rod.sg.Listeners.SpecListener;
import net.rod.sg.Listeners.WeatherListener;
import net.rod.sg.Utils.GameUtils;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class SG
  extends JavaPlugin
  implements Listener
{
  public static SG plugin;
  public static ArrayList<Player> sidebar = new ArrayList();
  public boolean allowToMove = false;
  public static String console = "§cThis command is not allowed from console!";
  public Logger log = Logger.getLogger("Minecraft");
  public java.util.List<Location> tier2_chests = new ArrayList();
  public ArrayList<Location> tier1chest = new ArrayList();
  public static String pr = "§8[§6SoloSG§8] §r";
  public static String noperm = "§cYou don't have permission for this command!";
  public static File config = new File("plugins/SHSG", "spawns.yml");
  public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(config);
  public static File motd = new File("SG1/plugins/SHSG", "motd.yml");
  public static FileConfiguration mtd = YamlConfiguration.loadConfiguration(motd);
  public static int minplayers = 6;
  public static int livegamedm = 1;
  public static boolean ranked = true;
  public static HashMap<Player, Integer> playerNumber = new HashMap();
  public static boolean forcestart = false;
  public static String map = null;
  public static String mapname1;
  public static String mapname2;
  public static String mapname3;
  public static String mapname4;
  public static int serverid;
  public static String mapname5;
  public static String title = "§aLobby §c1:30";
  public static boolean mapcreated = false;
  public static boolean tear1 = false;
  public static boolean tear2 = false;
  public boolean lobby;
  public boolean end;
  public static boolean refill = false;
  public java.util.List<Location> openedchests = new ArrayList();
  public static HashMap<Location, Inventory> sgchest = new HashMap();
  public static ArrayList<Player> tributes = new ArrayList();
  public static ArrayList<Player> spectators = new ArrayList();
  public static File file2 = new File("plugins/SHSG", "Skins.yml");
  public static FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
  ArrayList<String> worlds = new ArrayList();
  private File mapFolder;
  private FileManager fileManager;
  private WorldUtils worldUtils;
  public static String developer;
  public static String developer2;
  public static boolean MapReset = true;
  public static boolean worldsave = false;
  public static String mappool = "v1";
  public static String w = "SGLobby";
  public static String w1 = "AlaskanVillage";
  public static String w2 = "SurvivalGames4";
  public static String w3 = "BreezeIsland2";
  public static String w4 = "Par72";
  public static String w5 = "HolidayResort2";
  public static String w6 = "Turbulence";
  public static String w7 = "Zone85";
  public static String w8 = "LobbyGames";
  public static String w9 = "SurvivalGamesAdrenaline";
  public static String w10 = "DemonsBreeze";
  public static java.util.List<String> haritalar;
  public static ArrayList<String> worldler = new ArrayList();
  public static String mod;
  public static String renk;
  
  public void onEnable()
  {
    plugin = this;
    if (config.exists()) {
      try
      {
        config.createNewFile();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    SG.plugin.nameField = getField(GameProfile.class, "name");
    Bukkit.getPluginManager().registerEvents(new Events(this), this);
    getConfig().options().copyDefaults(true);
    saveDefaultConfig();
    saveConfig();
    haritalar = getConfig().getStringList("Vote-Maps");
    Bukkit.getPluginManager().registerEvents(this, this);
    Segm.setSegment(Segm.GameSegments.LOBBY);
    getConfig().options().copyDefaults(true);
    saveConfig();
    Bukkit.getPluginManager().registerEvents(this, this);
    serverid = getConfig().getInt("ServerID");
    getCommand("vote").setExecutor(new vote());
    getCommand("stats").setExecutor(new StatsCommand());
    getCommand("setspawn").setExecutor(new setSpawn());
    getCommand("setlobby").setExecutor(new setLobby());
    getCommand("setspec").setExecutor(new setSpec());
    getCommand("forcestart").setExecutor(new Forcestart());
    getCommand("spectate").setExecutor(new Spectate());
    getCommand("list").setExecutor(new net.rod.sg.Commands.List());
    getCommand("sg").setExecutor(new net.rod.sg.Commands.SG());
    getCommand("chatcolor").setExecutor(new net.rod.sg.Commands.ChatColor());
    getCommand("addvote").setExecutor(new net.rod.sg.Commands.SG());
    getCommand("bounty").setExecutor(new Bounty());
    getCommand("confirmbounty").setExecutor(new Bounty());
    getCommand("setbounty").setExecutor(new Bounty());
    getCommand("resetbounty").setExecutor(new Bounty());
    getCommand("fly").setExecutor(new FlyCommand());
    getCommand("segment").setExecutor(new SegmentCommand());
    getCommand("lobby").setExecutor(new Lobby());
    getCommand("test").setExecutor(new Test());
    Segm.setSegment(Segm.GameSegments.LOBBY);
    RegisterEvents();
    Player all;
    for (Iterator localIterator1 = Bukkit.getOnlinePlayers().iterator(); localIterator1.hasNext();)
    {
      all = (Player)localIterator1.next();
      all.teleport(GameUtils.teleportLobby());
    }
    if (Bukkit.getServer().getPluginManager().isPluginEnabled("PermissionsEx")) {
;
    } else {
      Logger.getLogger("Minecraft").warning(".");
    }
    Mapreset.start();
    worldler.add(w);
    worldler.add(w1);
    worldler.add(w2);
    worldler.add(w3);
    worldler.add(w4);
    worldler.add(w5);
    worldler.add(w6);
    worldler.add(w7);
    worldler.add(w8);
    worldler.add(w9);
    World wg = Bukkit.getWorld(w);
    World sg1 = Bukkit.getWorld(w1);
    World sg2 = Bukkit.getWorld(w2);
    World sg3 = Bukkit.getWorld(w3);
    World sg4 = Bukkit.getWorld(w4);
    World sg5 = Bukkit.getWorld(w5);
    World sg6 = Bukkit.getWorld(w6);
    World sg7 = Bukkit.getWorld(w7);
    World sg8 = Bukkit.getWorld(w8);
    World sg9 = Bukkit.getWorld(w9);
    
    Bukkit.createWorld(WorldCreator.name(String.valueOf("SGLobby")));
    Bukkit.createWorld(WorldCreator.name(String.valueOf("SurvivalGames4")));
    for (String wgg : worldler) {
      Bukkit.createWorld(WorldCreator.name(wgg));
    }
    if (wg == null) {
      Bukkit.createWorld(WorldCreator.name(w));
    }
    if (sg1 == null) {
      Bukkit.createWorld(WorldCreator.name(w1));
    }
    if (sg2 == null) {
      Bukkit.createWorld(WorldCreator.name(w2));
    }
    if (sg3 == null) {
      Bukkit.createWorld(WorldCreator.name(w3));
    }
    if (sg4 == null) {
      Bukkit.createWorld(WorldCreator.name(w4));
    }
    if (sg5 == null) {
      Bukkit.createWorld(WorldCreator.name(w5));
    }
    if (sg6 == null) {
      Bukkit.createWorld(WorldCreator.name(w6));
    }
    if (sg7 == null) {
      Bukkit.createWorld(WorldCreator.name(w7));
    }
    if (sg8 == null) {
      Bukkit.createWorld(WorldCreator.name(w8));
    }
    if (sg9 == null) {
      Bukkit.createWorld(WorldCreator.name(w9));
    }
    
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    
    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
  }
  
  public void onDisable()
  {
    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-off");
    if (Mapreset.isEnabled())
    {
      Mapreset.stop();
      Mapreset.reset();
    }
    for (String wd : worldler) {
      Bukkit.getServer().unloadWorld(wd, true);
    }
  }
  
  public static void RegisterEvents()
  {
    Bukkit.getPluginManager().registerEvents(new JoinQuitListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new EVENT_Board(), plugin);
    Bukkit.getPluginManager().registerEvents(new WeatherListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new MoveListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new DeathListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new ChatListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new Achievement(), plugin);
    Bukkit.getPluginManager().registerEvents(new BuildListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new MotdListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new MobListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new InteractListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new DamageListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new SpecListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new FoodLevelListener(), plugin);
    Bukkit.getPluginManager().registerEvents(new Dev(), plugin);
    Bukkit.getPluginManager().registerEvents(new Mapreset.MapResetListeners(), plugin);
  }
  
  public static String getGroupName(Player player)
  {
    int top = Integer.MAX_VALUE;
    PermissionGroup topGroup = null;
    PermissionGroup[] arrayOfPermissionGroup;
    int j = (arrayOfPermissionGroup = PermissionsEx.getUser(player).getGroups()).length;
    for (int i = 0; i < j; i++)
    {
      PermissionGroup group = arrayOfPermissionGroup[i];
      int rank = group.getRank();
      if (rank > top)
      {
        top = rank;
        topGroup = group;
      }
    }
    if (topGroup == null) {
      return null;
    }
    return topGroup.getName();
  }
  
  public String getUUID(String name)
  {
    return Bukkit.getOfflinePlayer(name).getUniqueId().toString().replace("-", "");
  }
  private Field nameField;

  public void nameset(Player p1, String toName)
  {
    final Player p = p1.getPlayer();
    
    String name = toName;
    if (name.length() <= 16)
    {
      final CraftPlayer cp = (CraftPlayer)p;
      try
      {
        this.nameField.set(cp.getProfile(), name);
      }
      catch (IllegalArgumentException|IllegalAccessException e)
      {
        e.printStackTrace();
      }
      PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[] { cp.getEntityId() });
      sendPacket(destroy);
      removeFromTab(cp);
      
      new BukkitRunnable()
      {
        public void run()
        {
          SG.this.addToTab(cp);
          PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(cp.getHandle());
          for (Player all : Bukkit.getOnlinePlayers()) {
            if (!all.equals(p)) {
              ((CraftPlayer)all).getHandle().playerConnection.sendPacket(spawn);
            }
          }
        }
      }.runTaskLater(this, 4L);
    }
  }
  
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
    for (Player all : Bukkit.getOnlinePlayers()) {
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
  
  public void skinset(Player p, String toSkin)
  {
    final Player sender = p.getPlayer();
    String name = toSkin;
    
    GameProfile gp = ((CraftPlayer)sender).getProfile();
    gp.getProperties().clear();
    Skin skin = new Skin(getUUID(name));
    if (skin.getSkinName() != null) {
      gp.getProperties().put(skin.getSkinName(), new Property(skin.getSkinName(), skin.getSkinValue(), skin.getSkinSignatur()));
    }
    Bukkit.getScheduler().runTaskLater(this, new Runnable()
    {
      public void run()
      {
        for (Player pl :Bukkit.getOnlinePlayers() ) {
          pl.hidePlayer(sender);
        }
      }
    }, 1L);
    
    Bukkit.getScheduler().runTaskLater(this, new Runnable()
    {
      public void run()
      {
        for (Player pl : Bukkit.getOnlinePlayers() ) {
          pl.showPlayer(sender);
        }
      }
    }, 20L);
  }
}
