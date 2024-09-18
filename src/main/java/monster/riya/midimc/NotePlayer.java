package monster.riya.midimc;

import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.Map;

public class NotePlayer {

    public static void note(int note) {

        Tone[] tones = Tone.values();
        int noteIndex = note % 12;
        Tone tone = tones[noteIndex];

        int octave = (note / 12) - 1;

        Sound[] sonuds = {
                Sound.BLOCK_NOTE_BLOCK_BASEDRUM,
                Sound.BLOCK_NOTE_BLOCK_BASS,
                Sound.BLOCK_NOTE_BLOCK_GUITAR,
                Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE,
                Sound.BLOCK_NOTE_BLOCK_PLING,
                Sound.BLOCK_NOTE_BLOCK_BELL,
                Sound.BLOCK_NOTE_BLOCK_CHIME,
                Sound.BLOCK_NOTE_BLOCK_XYLOPHONE,
        };
        NoteViewer.add(Map.entry(tone, octave));
        MidiManager.targetPlayer.playSound(MidiManager.targetPlayer.getEyeLocation().add(0, 1, 0), sonuds[octave + 1], 1, tone.getPitch());
    }
}
