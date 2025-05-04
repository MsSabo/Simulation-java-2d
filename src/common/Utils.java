package common;


import board.Board;
import board.Cell;
import entities.Entity;
import entities.animals.*;
import entities.inanimate.Grass;

import java.util.*;

public class Utils {
    public static <T> Map<Cell, Creature> find(Board board, Class<T> tClass) {
        var creatures = new HashMap<Cell, Creature>();

        for (Map.Entry<Cell, Entity> entry : board.getMap().entrySet())
        {
            if (tClass.isInstance(entry.getValue()))
            {
                creatures.put(entry.getKey(), (Creature) entry.getValue());
            }
        }

        return creatures;
    }

    public static boolean isOver(Board board) {
        for (Map.Entry<Cell, Entity> entry : board.getMap().entrySet())
        {
            if (entry.getValue() instanceof Herbove)
            {
                return false;
            }
        }

        return true;
    }
}
