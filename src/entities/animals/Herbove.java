package entities.animals;

import board.Board;
import board.Cell;
import route_builder.RouteBuilder;

public class Herbove extends Creature {
    public Herbove(RouteBuilder routeBuilder) {
        super(1, 100, routeBuilder);
    }

    @Override
    public String getSign() {
        return "🐑";
    }

    @Override
    public void eat(Cell grass, Board board) {
         System.out.println("Herbove eated");
         board.remove(grass);
    }
}