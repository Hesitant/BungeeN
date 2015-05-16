package pw.s7w.objects;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import pw.s7w.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Alex on 5/15/2015.
 */
public class Profile {


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


    public Profile(ProxiedPlayer p, String ip, String[] ipaddresses, String[] altAccounts) {
        player = p;
        alts = new ArrayList<String>();
        ips = new ArrayList<String>();
        ipaddress = ip;
        id = p.getUniqueId();
        for (String ipList : ipaddresses) {
            ips.add(ipList);
        }
        for (String altAccountsList : altAccounts) {
            alts.add(altAccountsList);
        }

        profileFile = new File (Main.get().getDataFolder() + File.separator + "users", p.getUniqueId().toString());
        if (profileFile.exists()) {
            try {
                profileConfig = ConfigurationProvider.getProvider(YamlConfiguration.class).load(profileFile);
                p.sendMessage(ChatColor.GREEN + "Profile loaded.");
            } catch (IOException e) {
                e.printStackTrace();
                Main.get().severe("Error loading profile for " + p.getName() + "!");
            }
        } else {
            try {
                profileFile.createNewFile();
                profileConfig = ConfigurationProvider.getProvider(YamlConfiguration.class).load(profileFile);
                profileConfig.set("NAME", player);
                profileConfig.set("IP", ip);
                profileConfig.set("IPS", ips);
                profileConfig.set("ALTS", alts);
                p.sendMessage(ChatColor.GREEN + "Profile created.");
            } catch (IOException e) {
                e.printStackTrace();
                Main.get().severe("Error creating profile for " + p.getName() + "!");
            }
        }
    }
}