package top.minicraft.BWUP.CommandExcuters;

import io.github.bedwarsrel.BedwarsRel;
import io.github.bedwarsrel.game.Game;
import io.github.bedwarsrel.game.Team;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.minicraft.BWUP.Utils.ConfigUtil;

public class bwup implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender Sender, Command command, String s, String[] args) {
        if(s.equalsIgnoreCase("BWUP")){
            if (Sender instanceof Player) {
                Player p = (Player)Sender;
                if(args.length == 0){
                    p.sendMessage(new String[]{"==========BWUP==========","/bwup 主指令","/bwup help 帮助指令","/bwup setUP <Player> <Team> <Game> 为此游戏添加升级村民（在你所在的位置）"});
                    return true;
                }
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("help")){
                        p.sendMessage(new String[]{"==========BWUP==========","/bwup 主指令","/bwup help 帮助指令","/bwup setUP <Team> <Game> 为此游戏添加升级村民（在你所在的位置）"});
                        return true;
                    }
                    if(args[0].equalsIgnoreCase("setup")){
                        p.sendMessage("Need More Things!!");
                        return true;
                    }
                }
                if (args.length == 3){
                    if(args[0].equalsIgnoreCase("setup")){
                        Game g = BedwarsRel.getInstance().getGameManager().getGame(args[2]);
                        Team t = g.getTeam(args[1]);
                        Location l = p.getLocation();
                        ConfigUtil.setLocation(g.getName(),t.getName(),l);
                        return true;
                    }
                }
            }else {
                Sender.sendMessage(ChatColor.RED + "Sorry,but you are not a player");
                return true;
            }
        }
        return false;
    }
}
