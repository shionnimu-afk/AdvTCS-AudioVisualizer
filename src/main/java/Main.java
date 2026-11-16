import processing.core.PApplet;
import java.util.ArrayList;
import processing.sound.*;


public class Main extends PApplet {

    public enum Program_State {
        Main_Menu,
        Comp1,
        Comp2
    }

    private Component1 component1;
    private Program_State currentState = Program_State.Main_Menu;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(1200, 600);

    }

    public void setup() {
        background(0);
        component1 = new Component1(this);
    }


    public void keyPressed() {
        if(currentState == Program_State.Main_Menu) {
            setProgramState(key);
        }
        else if(currentState == Program_State.Comp1) {
            component1.handleKeyPressed(key, keyCode);
        }
    }

    public void setProgramState(char key) {
        if(key == '1') {
            currentState = Program_State.Comp1;
        }
        if(key == '2') {
            currentState = Program_State.Comp2;
        }

    }

    public void draw() {
        if(currentState == Program_State.Main_Menu) {
            background(0);
            fill(255);
            textSize(40);
            text("Component 1 (click 1)", 50, 50);
            text("Component 2 (WILL NOT RUN)", 50, 150);
        }
        if (currentState == Program_State.Comp1) {
            component1.draw();
        }
        if (currentState == Program_State.Comp2) {
            //component2.draw();
        }


    }
}
