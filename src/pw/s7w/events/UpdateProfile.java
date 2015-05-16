package pw.s7w.events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by S7W on 16/05/2015.
 */
public class UpdateProfile implements Listener {


    @EventHandler
    public void onHandle(LoginEvent e) {
        ProxiedPlayer p = (ProxiedPlayer) e.getConnection();
        for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
            if(players.hasPermission("network.join")) {
                players.sendMessage(p.getName() + "§c has joined network.");
            }
        }
    }
}
