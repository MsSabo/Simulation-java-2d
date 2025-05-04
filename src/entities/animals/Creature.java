package entities.animals;

import board.Board;
import board.Cell;
import entities.Entity;
import route_builder.RouteBuilder;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp;
    protected final RouteBuilder routeBuilder;

    public Creature(int speed, int hp, RouteBuilder routeBuilder) {
        this.speed = speed;
        this.hp = hp;
        this.routeBuilder = routeBuilder;
    }

    public void makeMove(Cell start, Board board) {
        Cell[] route = routeBuilder.route(start, board);

        if (route.length == 0) {
            System.out.println("Route not found");
        }
        else if (route.length == 1) {
            System.out.println("Herbove eated");
            eat(route[0], board);
        }
        else {
            System.out.println("Herbove move");
            board.move(start, route[1]);
        }
    }

    abstract public void eat(Cell start, Board board);
}
