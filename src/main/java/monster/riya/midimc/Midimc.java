package monster.riya.midimc;

import monster.riya.midimc.command.StartCommand;
import monster.riya.midimc.command.StopCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Midimc extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new NoteViewer(), this);
        this.getCommand("mstart").setExecutor(new StartCommand());
        this.getCommand("mstop").setExecutor(new StopCommand());
        getLogger().info("Midimc Plugin Enabled");
    }

    @Override
    public void onDisable() {
        MidiManager.stop();
        getLogger().info("Midimc Plugin Disabled");
    }
}
