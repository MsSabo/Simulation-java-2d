package action;

import board.Board;
import board.Cell;
import entities.animals.Herbove;
import entities.inanimate.Grass;
import route_builder.BfsBuilder;
import route_builder.RouteBuilder;
import common.Config;
import java.util.Random;

public class InitAction implements Action {
    @Override
    public void execute(Board board)
    {
        var cfg = Config.get();
        RouteBuilder grassFinder = new BfsBuilder<>(Grass.class);
        RouteBuilder sheepFinder = new BfsBuilder<>(Herbove.class);

        var rand = new Random();
        int r = 10;
        int c = 10;

        for (int i = 0; i < cfg.predators; i++)
        {
            board.add(new Cell(rand.nextInt(r), rand.nextInt(c)), new entities.animals.Predator(sheepFinder));
        }

        for (int i = 0; i < cfg.herboves; i++)
        {
            board.add(new Cell(rand.nextInt(r), rand.nextInt(c)), new entities.animals.Herbove(grassFinder));
        }

        for (int i = 0; i < cfg.grass; i++)
        {
            board.add(new Cell(rand.nextInt(r), rand.nextInt(c)), new entities.inanimate.Grass());
        }

        for (int i = 0; i < cfg.trees; i++)
        {
            board.add(new Cell(rand.nextInt(r), rand.nextInt(c)), new entities.inanimate.Tree());
        }

        for (int i = 0; i < cfg.rocks; i++)
        {
            board.add(new Cell(rand.nextInt(r), rand.nextInt(c)), new entities.inanimate.Rock());
        }
    }
}
