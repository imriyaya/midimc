package monster.riya.midimc;

public enum Tone {
    C(0.707107f),
    Cs(0.749154f),
    D(0.793701f),
    Ds(0.840896f),
    E(0.890899f),
    F(0.943874f),
    Fs(1.0f),
    G(1.059463f),
    Gs(1.122462f),
    A(1.189207f),
    As(1.259921f),
    B(1.334840f);

    private final float pitch;

    private Tone(float pitch) {
        this.pitch = pitch;
    }

    public float getPitch() {
        return pitch;
    }
}
