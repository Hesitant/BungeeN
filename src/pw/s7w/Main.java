package pw.s7w;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;
import pw.s7w.events.UpdateProfile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alex on 5/15/2015.
 */
public class Main extends Plugin {


    private static Main instance;
    public void onEnable() {
        instance = this;

        if (!(getDataFolder().exists())) {
            getDataFolder().mkdir();
        }

        File mainFile = new File(getDataFolder(), "users.yml");
        if (!(mainFile.exists())) {
            mainFile.mkdir();
        }

        File staffFile = new File(getDataFolder(), "staff.yml");
        if (!(staffFile.exists())) {
            try {
                staffFile.createNewFile();
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

    public void log(String s) {
        BungeeCord.getInstance().getLogger().info(s);
    }

    public void severe(String s) {
        BungeeCord.getInstance().getLogger().severe(s);
    }


}
