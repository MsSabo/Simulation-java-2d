package board;

import java.util.HashMap;
import java.util.Map;
import entities.Entity;

public class Board {
    private Map<Cell, Entity> map;

    public Board()
    {
        this.map = new HashMap<Cell, Entity>();
    }

    public void add(Cell cell, Entity entity)
    {
        map.put(cell, entity);
    }

    public void remove(Cell cell)
    {
        map.remove(cell);
    }

    public final Map<Cell, Entity> getMap() {
        return map;
    }
}
