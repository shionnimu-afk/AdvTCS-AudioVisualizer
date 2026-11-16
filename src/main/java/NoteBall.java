import processing.core.PApplet;
import processing.sound.SinOsc;

public class NoteBall {
    private Note note;
    private int radius;
    private int speed;
    private int xPos;
    private int yPos;
    private SinOsc oscillator;
    private int soundStopTime;
    private boolean soundPlaying;

    public NoteBall(int xPos, int yPos, int speed, Note note, SinOsc oscillator) {
        this.radius = 15;
        this.speed = 2;
        this.xPos = xPos;
        this.yPos = 300;
        this.note = note;
        this.oscillator = oscillator;
    }

    public void move() {
        yPos+=speed;
        if(yPos >= 550) {
            speed *= -1;
        }
        if(yPos < 50) {
            speed *= -1;
        }
    }

    public void display(PApplet p) {
        p.stroke(note.getR(), note.getG(), note.getB());
        p.circle(xPos, yPos, radius);
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void playNote(PApplet p) {
        oscillator.play(note.getFrequency(), 0.5f);
        soundStopTime = p.millis() + 500;
        soundPlaying = true;
    }

    public void updateSound(PApplet p) {
        if(p.millis() > soundStopTime && soundPlaying) {
            oscillator.stop();
        }
    }

}
