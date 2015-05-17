package pw.s7w;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import pw.s7w.events.UpdateProfile;
import pw.s7w.managers.ProfileManager;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alex on 5/15/2015.
 */
public class Main extends Plugin {

    private ProfileManager pm;
    private static Main instance;

    public void onEnable() {
        instance = this;
        pm = new ProfileManager();
        if (!(getDataFolder().exists())) {
            getDataFolder().mkdir();
        }

        File mainFile = new File(getDataFolder(), "users");
        if (!(mainFile.exists())) {
            mainFile.mkdir();
        }

        File staffFile = new File(getDataFolder(), "staff.yml");
        if (!(staffFile.exists())) {
            try {
                staffFile.createNewFile();
                getProxy().getConsole().sendMessage(new TextComponent("§cCreated staff.yml"));
            } catch (IOException e) {
                e.printStackTrace();
                severe("Error creating 'staff.yml'");

            }
        }
        getProxy().getPluginManager().registerListener(this, new UpdateProfile());
    }

    public static Main get() {
        return instance;
    }

    public ProfileManager getProfileManager() {
        return pm;
    }

    public void log(String s) {
        BungeeCord.getInstance().getLogger().info(s);
    }

    public void severe(String s) {
        BungeeCord.getInstance().getLogger().severe(s);
    }


}
