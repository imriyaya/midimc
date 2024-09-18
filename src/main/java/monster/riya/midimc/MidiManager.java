package monster.riya.midimc;

import org.bukkit.entity.Player;

import javax.sound.midi.*;
import java.io.File;
import java.util.Map;

public class MidiManager {

    private static Sequence playingSequence = null;
    private static final Sequencer sequencer;
    public static Player targetPlayer;

    static {
        try {
            sequencer = MidiSystem.getSequencer(false);
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void play(String file) throws Exception {
        if (playingSequence != null) {
            stop();
        }


        playingSequence = MidiSystem.getSequence(new File(file));
        sequencer.getTransmitter().setReceiver(new Receiver() {
            @Override
            public void send(MidiMessage message, long timeStamp) {
                if (message instanceof ShortMessage sm) {
                    if (sm.getCommand() == ShortMessage.NOTE_ON) {
                        int note = sm.getData1();
                        int velocity = sm.getData2();
                        NotePlayer.note(note);
                    }
                }
            }

            @Override
            public void close() {
            }
        });
        sequencer.setSequence(playingSequence);
        sequencer.open();
        sequencer.start();
    }

    public static void stop() {
        if (playingSequence == null) return;
        for (Track track : playingSequence.getTracks()) {
            playingSequence.deleteTrack(track);
        }
        sequencer.stop();
        sequencer.close();
        playingSequence = null;
    }

    public static boolean isPlaying() {
        return playingSequence != null;
    }
}
