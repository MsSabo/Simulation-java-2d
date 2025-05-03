package route_builder;
import board.Board;
import board.Cell;

public interface RouteBuilder {
    public Cell[] route(Cell start, Board board);
}
