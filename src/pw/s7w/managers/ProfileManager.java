package pw.s7w.managers;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.config.Configuration;
import pw.s7w.objects.Profile;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by S7W on 15/05/2015.
 */
public class ProfileManager {

    ProxiedPlayer player;
    File profileFile;
    Configuration profileConfig;
    ArrayList alts;
    ArrayList ips;
    UUID id;
    String ipaddress;
    String banreason;
    String bannedby;
    boolean banned;


}
