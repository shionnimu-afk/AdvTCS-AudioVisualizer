import processing.core.PApplet;
import java.util.ArrayList;
import processing.sound.*;


public class Main extends PApplet {

    private Component1 component1;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(1200,600);

    }

    public void setup() {
        component1 = new Component1(this);
    }


    public void keyPressed() {
        component1.handleKeyPressed(key);
    }

    public void draw() {
        component1.draw();
    }

}
