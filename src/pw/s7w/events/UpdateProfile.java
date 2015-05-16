package pw.s7w.events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import pw.s7w.Main;
import pw.s7w.objects.Profile;


/**
 * Created by S7W on 16/05/2015.
 */
public class UpdateProfile implements Listener {


    @EventHandler
    public void onHandleLogin(LoginEvent e) {
        ProxiedPlayer p = (ProxiedPlayer) e.getConnection();
        Profile profile = new Profile(p, p.getAddress().toString(), null, null);
        
        for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
            if(players.hasPermission("network.join")) {
                players.sendMessage(p.getName() + "§c has joined the network. Server [" + Main.get().getProxy().getName() + "]");
            }
        }
    }
}
