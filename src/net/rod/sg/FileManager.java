package net.rod.sg;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class FileManager
{
  private File file;
  private FileConfiguration cfg;
  private Plugin thePlugin;
  
  public FileConfiguration getConfig()
  {
    return this.cfg;
  }
  
  public FileManager(Plugin thePlugin, String cfg)
  {
    this.thePlugin = thePlugin;
    this.file = new File(thePlugin.getDataFolder(), cfg);
    this.cfg = YamlConfiguration.loadConfiguration(this.file);
    this.cfg.options().header("Configuration for " + this.thePlugin.getDescription().getName() + " version " + 
      this.thePlugin.getDescription().getVersion());
    saveConfig();
  }
  
  public void saveConfig()
  {
    try
    {
      this.cfg.save(this.file);
    }
    catch (IOException localIOException) {}
  }
  
  public String getPluginName()
  {
    return this.thePlugin.getDescription().getName();
  }
  
  public List<String> getList(String name)
  {
    return this.cfg.getStringList(String.valueOf(getPluginName()) + "." + name);
  }
  
  public void set(String valuename, Object value)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + valuename, value);
    saveConfig();
  }
  
  public boolean is(String valuename)
  {
    return this.cfg.contains(String.valueOf(getPluginName()) + "." + valuename);
  }
  
  public void setBoolean(String booleanname, boolean value)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + booleanname, Boolean.valueOf(value));
    saveConfig();
  }
  
  public boolean getBoolean(String booleanname)
  {
    return this.cfg.getBoolean(String.valueOf(getPluginName()) + "." + booleanname);
  }
  
  public void setString(String stringname, String value)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + stringname, value);
    saveConfig();
  }
  
  public String getString(String stringname)
  {
    return this.cfg.getString(String.valueOf(getPluginName()) + "." + stringname);
  }
  
  public void setInt(String intname, int value)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + intname, Integer.valueOf(value));
    saveConfig();
  }
  
  public int getInt(String intname)
  {
    return this.cfg.getInt(String.valueOf(getPluginName()) + "." + intname);
  }
  
  public void setDouble(String intname, double value)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + intname, Double.valueOf(value));
    saveConfig();
  }
  
  public double getDouble(String intname)
  {
    return this.cfg.getDouble(String.valueOf(getPluginName()) + "." + intname);
  }
  
  public void setLocation(String locname, World w, double x, double y, double z, float yaw, float pitch)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".w", w.getName());
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".x", Double.valueOf(x));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".y", Double.valueOf(y));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".z", Double.valueOf(z));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".yaw", Float.valueOf(yaw));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".pitch", Float.valueOf(pitch));
    saveConfig();
  }
  
  public void deleteLocation(String locname)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".w", null);
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".x", null);
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".y", null);
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".z", null);
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".yaw", null);
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".pitch", null);
    saveConfig();
  }
  
  public void setLocation(String locname, Player p)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".w", p.getWorld().getName());
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".x", Double.valueOf(p.getLocation().getX()));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".y", Double.valueOf(p.getLocation().getY()));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".z", Double.valueOf(p.getLocation().getZ()));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".yaw", Float.valueOf(p.getLocation().getYaw()));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".pitch", 
      Float.valueOf(p.getLocation().getPitch()));
    saveConfig();
  }
  
  public void setBlockLocation(String locname, Location loc)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".w", loc.getWorld().getName());
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".x", Integer.valueOf(loc.getBlockX()));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".y", Integer.valueOf(loc.getBlockY()));
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname + ".z", Integer.valueOf(loc.getBlockZ()));
    saveConfig();
  }
  
  public Location getBlockLocation(String locname)
  {
    return new Location(
      Bukkit.getWorld(this.cfg.getString(String.valueOf(getPluginName()) + "." + locname + ".w")), 
      this.cfg.getInt(String.valueOf(getPluginName()) + "." + locname + ".x"), 
      this.cfg.getInt(String.valueOf(getPluginName()) + "." + locname + ".y"), 
      this.cfg.getInt(String.valueOf(getPluginName()) + "." + locname + ".z"));
  }
  
  public Location getLocation(String locname)
  {
    return new Location(
      Bukkit.getWorld(this.cfg.getString(String.valueOf(getPluginName()) + "." + locname + ".w")), 
      this.cfg.getDouble(String.valueOf(getPluginName()) + "." + locname + ".x"), 
      this.cfg.getDouble(String.valueOf(getPluginName()) + "." + locname + ".y"), 
      this.cfg.getDouble(String.valueOf(getPluginName()) + "." + locname + ".z"), 
      
      Float.valueOf(this.cfg.getString(String.valueOf(getPluginName()) + "." + locname + ".yaw")).floatValue(), 
      
      Float.valueOf(this.cfg.getString(String.valueOf(getPluginName()) + "." + locname + ".pitch")).floatValue());
  }
  
  public boolean isLocation(String locname)
  {
    return this.cfg.contains(String.valueOf(getPluginName()) + "." + locname + ".x");
  }
  
  public void delete(String locname)
  {
    this.cfg.set(String.valueOf(getPluginName()) + "." + locname, null);
    saveConfig();
  }
}
