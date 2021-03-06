package de.sabbertran.proxytickets.bukkit;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class ProxyTicketsBukkit extends JavaPlugin {
    private HashMap<String, Location> pendingLocationTeleports;

    @Override
    public void onEnable() {
        pendingLocationTeleports = new HashMap<String, Location>();

        getServer().getMessenger().registerOutgoingPluginChannel(this, "ProxyTickets");
        getServer().getMessenger().registerIncomingPluginChannel(this, "ProxyTickets", new PMessageListener(this));

        getServer().getPluginManager().registerEvents(new Events(this), this);

        getLogger().info(getDescription().getName() + " " + getDescription().getVersion() + " by " + getDescription().getAuthors().get(0) + " enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " " + getDescription().getVersion() + " by " + getDescription().getAuthors().get(0) + " disabled");
    }

    public HashMap<String, Location> getPendingLocationTeleports() {
        return pendingLocationTeleports;
    }
}
