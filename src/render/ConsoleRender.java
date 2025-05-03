package render;

import board.Board;
import board.Cell;

public class ConsoleRender implements Render {
    public void draw(Board board) {
        var row = board.getWidth();
        var col = board.getHeight();

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                var obj = board.get(new Cell(x, y));
                if (obj != null) {
                    System.out.print(obj.getSign());
                }
                else {
                    System.out.print("🟫");
                }
            }
            System.out.println();
        }
    }
}
