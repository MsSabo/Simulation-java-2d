package action;

import board.Board;
import board.Cell;
import entities.*;

import java.util.Random;

public class InitAction {
    public void execute(Board board)
    {
        var rand = new Random();
        int r = 10;
        int c = 10;

        for (int i = 0; i < 5; i++)
        {
            board.add(new Cell(rand.nextInt(r), rand.nextInt(c)), new entities.inanimate.Grass());
        }
    }
}
