package monster.riya.midimc.command;

import monster.riya.midimc.MidiManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        MidiManager.targetPlayer = (Player) commandSender;
        try {
            MidiManager.play(args[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
