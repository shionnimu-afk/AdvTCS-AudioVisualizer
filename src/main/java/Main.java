import processing.core.PApplet;
import java.util.ArrayList;
import processing.sound.*;


public class Main extends PApplet {

    private ArrayList<NoteBall> balls;
    private int numLines = 14;
    private int numBalls = 0;
    private int midLineX1 = 20;
    private int midLineX2 = 1180;
    private int midLineY = 300;
    private int soundStopTime;
    private boolean soundPlaying;

    private SinOsc oscillator;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(1200,600);
    }

    public void setup() {
        balls = new ArrayList<NoteBall>();
        background(0);
        stroke(255,255,255);
        strokeWeight(5);
        for(int pos = 80; pos <= 80*numLines; pos+=80) {
            line(pos, 50, pos, 550);
        }
        strokeWeight(10);
        line(midLineX1, midLineY, midLineX2, midLineY);

        oscillator = new SinOsc(this);
//        oscillator.play(420,0.5f);
    }


    public void keyPressed() {
        NoteBall ball;
        if(key == 'a') {
            ball = new NoteBall(80*(numBalls+1), 300, 5, Note.A);
            balls.add(ball);
            numBalls++;

            oscillator.play(420, 0.2f);
            soundStopTime = millis() + 1000;
            soundPlaying = true;
        }
        if(key == 'b') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.B);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'c') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.C);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'd') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.D);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'e') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.E);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'f') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.F);
            balls.add(ball);
            numBalls++;
        }
        if(key == 'g') {
            ball = new NoteBall(80*(numBalls+1), 50, 5, Note.G);
            balls.add(ball);
            numBalls++;
        }

    }

    public void draw() {
        background(0);
        stroke(255,255,255);
        strokeWeight(5);
        for(int pos = 80; pos <= 80*numLines; pos+=80) {
            line(pos, 50, pos, 550);
        }
        strokeWeight(10);
        line(20,300,1180,300);

        for(NoteBall ball : balls) {
            ball.move();
            ball.display(this);
            if(ball.getyPos() >= midLineY) {
                ball.playNote();
            }
        }

        if(soundPlaying && millis() >= soundStopTime) {
            oscillator.stop();
            soundPlaying = false;
        }
    }



}
