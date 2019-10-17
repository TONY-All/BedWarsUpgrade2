package top.minicraft.BWUP.Utils;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import top.minicraft.BWUP.BWUP;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ConfigUtil {
    private static File[] gamemaps;
    private static File MapDateFolder;

    public ConfigUtil(BWUP instance){
        MapDateFolder = new File(instance.getDataFolder(),File.pathSeparator+"Maps");
        gamemaps = MapDateFolder.listFiles();
    }
    public static String[] getSupportedMaps(){
        List<String> l = new ArrayList<String>();
        for (File gamemap : gamemaps) {
            l.add(gamemap.getName());
        }
        return (String[])l.toArray();
    }
    public static void setLocation(String game,String Team, Location l){
        File f = new File(MapDateFolder.getPath(),game+".yml");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration GameLoca = YamlConfiguration.loadConfiguration(f);
        GameLoca.set("Name",game);
        GameLoca.set("Location"+Team,l);
        try {
            GameLoca.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Location loadLocation(String game,String Team){
        File f = new File(MapDateFolder.getPath(),game+".yml");
        if(!f.exists()){
            return null;
        }
        YamlConfiguration GameLoca = YamlConfiguration.loadConfiguration(f);
        Location l = (Location)GameLoca.get("Location"+Team);
        return l;
    }
}