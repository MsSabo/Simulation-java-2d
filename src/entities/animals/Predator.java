package entities.animals;

import board.Board;
import board.Cell;
import route_builder.RouteBuilder;

public class Predator extends Creature {
    protected final int attackDmg;

    public Predator(RouteBuilder routeBuilder) {
        super(1, 100, routeBuilder);
        attackDmg = 25;
    }

    @Override
    public String getSign() {
        return "🦊";
    }

    @Override
    public void eat(Cell sheepCell, Board board) {
        var sheep = (Herbove)board.get(sheepCell);
        //sheep.hp -= attackDmg;

        //if (sheep.hp <= 0) {
            board.remove(sheepCell);
        //}
    }
}
