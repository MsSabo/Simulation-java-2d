package common;

import java.util.Scanner;

public class Config {
    public int row, column;
    public int herboves;
    public int predators;
    public int grass;
    public int trees;
    public int rocks;

    public Config(int row, int column, int herboves,
                  int predators, int grass,
                  int trees, int rocks) {
        this.row = row;
        this.column = column;
        this.herboves = herboves;
        this.predators = predators;
        this.grass = grass;
        this.trees = trees;
        this.rocks = rocks;
    }

    public boolean isValid() {
        return (row * column) > (herboves + predators + grass + trees + rocks);
    }

    public static Config get() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ширину карты: ");
        int column = scanner.nextInt();

        System.out.print("Введите высоту карты: ");
        int row = scanner.nextInt();

        System.out.print("Введите количество травы: ");
        int grass = scanner.nextInt();

        System.out.print("Введите количество овец: ");
        int sheep = scanner.nextInt();

        System.out.print("Введите количество лис: ");
        int foxes = scanner.nextInt();

        System.out.print("Введите количество деревьев: ");
        int trees = scanner.nextInt();

        System.out.print("Введите количество гор: ");
        int mountains = scanner.nextInt();

        var cfg = new Config(row, column, sheep, foxes, grass, trees, mountains);

        if (!cfg.isValid()) {
            System.out.println("Невалидная карта. Повторите ввод:");
            return get();
        }
        return cfg;
    }
}
