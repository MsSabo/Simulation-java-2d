import action.Action;
import action.InitAction;
import action.MoveAction;
import board.Board;
import render.Render;

import static common.Utils.isOver;

public class Simulation {
    private final Board board;
    private int count;
    private Render render;
    private final Action init;
    private final Action move;
    private final PauseController pauseController;
    private final Worker worker;

    private class PauseController {
        private boolean paused = false;
        private final Object pauseLock = new Object();

        void pause() {
            synchronized (pauseLock) {
                paused = true;
                pauseLock.notifyAll();
            }
        }

        void resume() {
            synchronized (pauseLock) {
                paused = false;
                pauseLock.notifyAll();
            }
        }

        void waitUntilPaused() throws InterruptedException {
            synchronized (pauseLock) {
                while (paused) {
                    pauseLock.wait();
                }
            }
        }
    }

    private class Worker implements Runnable {
        public Worker() {}

        @Override
        public void run() {
            try {
                while (!isOver(board)) {
                    pauseController.waitUntilPaused(); // приостановка, если нужно
                    nextTurn();
                    Thread.sleep(2000); // имитация работы
                }
            } catch (InterruptedException e) {
                System.out.println("Поток завершён");
            }
        }
    }

    public Simulation(int row, int col, Render render) {
        this.render = render;
        this.count = 0;
        this.board = new Board(row, col);
        this.init = new InitAction();
        this.move = new MoveAction();
        this.pauseController = new PauseController();
        this.worker = new Worker();
    }

    public void nextTurn()
    {
        move.execute(board);
        count++;
        render.draw(board);
    }

    public void start()
    {
        init.execute(board);
        Thread t = new Thread(worker);
        t.start();
    }

    public void pause()
    {
        pauseController.pause();
        System.out.println("Paused");
    }

    public void resume()
    {
        pauseController.resume();
        System.out.println("Resumed");
    }
}
