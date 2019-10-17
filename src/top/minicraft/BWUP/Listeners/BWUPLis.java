package top.minicraft.BWUP.Listeners;

import io.github.bedwarsrel.events.BedwarsGameStartedEvent;
import io.github.bedwarsrel.game.Game;
import io.github.bedwarsrel.game.Team;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BWUPLis implements Listener {
    @EventHandler
    public void GameStart(BedwarsGameStartedEvent e) {
        Game g = e.getGame();
        Team[] teams = (Team[]) g.getTeams().values().toArray();
        for (Team team : teams) {
            team.getName();

        }
    }
}

