import processing.core.PApplet;

public class NoteBall {
    private Note note;
    private int radius;
    private int speed;
    private int xPos;
    private int yPos;
    private int colorVal1;
    private int colorVal2;
    private int colorVal3;

    public NoteBall(int xPos, int yPos, int speed, Note note) {
        this.radius = 15;
        this.speed = 4;
        this.xPos = xPos;
        this.yPos = 300;
        this.note = note;
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

    public void playNote() {

    }

}
