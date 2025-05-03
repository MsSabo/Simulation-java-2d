package entities.animals;

import entities.Entity;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;

    public abstract void makeMove();
}
