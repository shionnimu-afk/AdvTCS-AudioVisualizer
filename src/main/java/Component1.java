import processing.core.PApplet;
import processing.sound.SinOsc;

import java.util.ArrayList;

public class Component1 {
    private ArrayList<NoteBall> balls;
    private int numLines = 14;
    private int numBalls = 0;
    private int midLineX1 = 20;
    private int midLineX2 = 1180;
    private int midLineY = 300;
    private int soundStopTime;
    private boolean soundPlaying;
    private PApplet p;

    private SinOsc oscillator;

    public Component1(PApplet p) {
        this.p = p;
        balls = new ArrayList<NoteBall>();
        p.background(0);
        p.stroke(255,255,255);
        p.strokeWeight(5);
        for(int pos = 80; pos <= 80*numLines; pos+=80) {
            p.line(pos, 50, pos, 550);
        }
        p.strokeWeight(10);
        p.line(midLineX1, midLineY, midLineX2, midLineY);
    }

    public void handleKeyPressed(char key) {
        SinOsc oscillator = new SinOsc(p);
        NoteBall ball = null;

        if(key == 'a') {
            ball = new NoteBall(80*(numBalls+1), 300, 5, Note.A, oscillator);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'b') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.B, oscillator);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'c') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.C, oscillator);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'd') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.D, oscillator);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'e') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.E, oscillator);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'f') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.F, oscillator);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'g') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.G, oscillator);
            balls.add(ball);
            numBalls++;
        }

        ball.playNote(p);
    }

    public void draw() {

        p.background(0);
        p.stroke(255,255,255);
        p.strokeWeight(5);
        for(int pos = 80; pos <= 80*numLines; pos+=80) {
            p.line(pos, 50, pos, 550);
        }
        p.strokeWeight(10);
        p.line(20,300,1180,300);

        for(NoteBall ball : balls) {
            ball.move();
            ball.display(p);
            if(ball.getyPos() == midLineY) {
                ball.playNote(p);
            }
            ball.updateSound(p);
        }
    }
}
