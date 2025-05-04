package route_builder;

import board.Board;
import board.Cell;
import entities.Entity;
import java.util.*;

public class BfsBuilder<T extends Entity> implements RouteBuilder {
    private final Class<T> tClass;

    public BfsBuilder(Class<T> tClass) {
        this.tClass = tClass;
    }

    public Cell[] route(Cell start, Board board)
    {
        // 4 направления движения (вверх, вправо, вниз, влево)
        Cell[] directions = new Cell[] {
                new Cell(1, 0),
                new Cell(0, 1),
                new Cell(-1, 0),
                new Cell(0, -1)
        };

        Map<Cell, Cell> route = new HashMap<>();
        Queue<Cell> queue = new LinkedList<>();
        queue.add(start);

        Cell destination = null;

        while (!queue.isEmpty()) {
            destination = queue.poll();
            Object obj = board.get(destination);

            if (tClass.isInstance(obj)) {
                break;
            }

            for (Cell dir : directions) {
                Cell neighbor = destination.plus(dir);
                boolean visited = route.containsKey(neighbor);
                boolean valid = board.isValid(neighbor);
                Object neighborObj = board.get(neighbor);

                boolean isTargetOrEmpty = neighborObj == null || tClass.isInstance(neighborObj);

                if (valid && !visited && isTargetOrEmpty) {
                    queue.add(neighbor);
                    route.put(neighbor, destination);
                }
            }
        }

        List<Cell> result = new ArrayList<>();

        // если цель не найдена
        if (destination == null || !tClass.isInstance(board.get(destination))) {
            return new Cell[0];
        }

        result.add(destination);
        Cell current = route.get(destination);
        while (current != null && !current.equals(start)) {
            result.add(current);
            current = route.get(current);
        }

        // Добавляем начальную точку
        result.add(start);

        // Разворачиваем список
        Collections.reverse(result);

        return result.toArray(new Cell[0]);
    }
}
