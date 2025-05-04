package action;

import board.Board;
import board.Cell;
import entities.animals.Creature;
import entities.animals.Herbove;
import entities.animals.Predator;

import java.util.Map;

import static common.Utils.find;

public class MoveAction implements Action{
    @Override
    public void execute(Board board) {
        Map<Cell, Creature> foxes = find(board, Predator.class);

        for(Map.Entry<Cell, Creature> entry : foxes.entrySet()) {
            entry.getValue().makeMove(entry.getKey(), board);
        }


        Map<Cell, Creature> sheeps = find(board, Herbove.class);

        for(Map.Entry<Cell, Creature> entry : sheeps.entrySet()) {
            entry.getValue().makeMove(entry.getKey(), board);
        }
    }
}
