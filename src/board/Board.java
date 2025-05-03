package board;

import java.util.HashMap;
import java.util.Map;
import entities.Entity;

public class Board {
    private final Map<Cell, Entity> map;
    private final int width;
    private final int height;

    public Board(int width, int height)
    {
        this.map = new HashMap<Cell, Entity>();
        this.width = width;
        this.height = height;
    }

    public boolean isValid(Cell cell) {
        return  (0 <= cell.getRow() && cell.getRow() < width) &&
                (0 <= cell.getColumn() && cell.getColumn() < height);
    }

    public void add(Cell cell, Entity entity)
    {
        map.put(cell, entity);
    }

    public void remove(Cell cell)
    {
        map.remove(cell);
    }

    public final Entity get(Cell cell) {
        return map.get(cell);
    }

    public final int getWidth() {
        return width;
    }

    public final int getHeight() {
        return height;
    }
}
