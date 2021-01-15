package net.rod.sg;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class LoadMap
{
  public static void loadWorld(World world)
  {
    if (!Bukkit.getWorlds().contains(world)) {
      Bukkit.getWorlds().add(world);
    }
  }
}
