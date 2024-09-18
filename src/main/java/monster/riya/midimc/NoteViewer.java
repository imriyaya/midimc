package monster.riya.midimc;

import com.destroystokyo.paper.event.server.ServerTickEndEvent;
import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NoteViewer implements Listener {

    private static final List<Map.Entry<Tone, Integer>> tones = new ArrayList<>();

    public static void add(Map.Entry<Tone, Integer> entry) {
        tones.add(entry);
    }

    @EventHandler
    private void onTick(ServerTickEndEvent event) {
        if (!MidiManager.isPlaying()) return;

        StringBuilder message = new StringBuilder("...................................................................... | ");
        char dot = '!';

            for (Map.Entry<Tone, Integer> tone : new ArrayList<>(tones)) {
                int index = Math.min(tone.getValue() * 7 + List.of(Tone.values()).indexOf(tone.getKey()), 70);
                message.setCharAt(index, dot);
                message.append(tone.getKey().name());
            }
            tones.clear();

        MidiManager.targetPlayer.sendMessage(message.toString());
    }
}