package top.minicraft.BWUP;

import org.bukkit.plugin.java.JavaPlugin;
import top.minicraft.BWUP.Utils.ConfigUtil;

public class BWUP extends JavaPlugin {
    @Override
    public void onEnable() {
        new ConfigUtil(this);
    }
}