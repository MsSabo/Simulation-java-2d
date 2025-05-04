import action.InitAction;
import action.MoveAction;
import board.Board;
import render.ConsoleRender;

import java.time.Duration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Simulation game = new Simulation(10, 10, new ConsoleRender());
        game.start();
    }
}