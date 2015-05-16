package pw.s7w.events;

import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by S7W on 16/05/2015.
 */
public class UpdateProfile implements Listener {

    @EventHandler
    public void onHandle(LoginEvent e) {
        String player = e.getConnection().getUniqueId().toString();

    }
}
