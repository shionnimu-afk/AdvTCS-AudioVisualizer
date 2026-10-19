public enum Note {

    C(261.63f, 255, 179, 0),
    D(293.66f, 255, 106, 0),
    E(329.63f, 255, 0, 0),
    F(349.23f, 238, 0, 255),
    G(392.00f, 132, 0, 255),
    A(440.0f, 0, 47, 255),
    B(493.88f, 0, 255, 110);

    private float frequency;
    private int r;
    private int g;
    private int b;

    Note(float frequency, int r, int g, int b) {
        this.frequency = frequency;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public float getFrequency() {
        return frequency;
    }

    public int getR() {
        return r;
    }
    public int getG() {
        return g;
    }
    public int getB() {
        return b;
    }

}
