import action.InitAction;
import board.Board;
import render.ConsoleRender;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var board = new Board(10, 10);

        var act = new InitAction();
        act.execute(board);

        var rend = new ConsoleRender();
        rend.draw(board);
    }
}