package Entities;
public class Dice {
    public Dice() {
    }

    public static int d20() {
        return (int) (Math.random() * 20) + 1;
    }

    public static int d10() {
        return (int) (Math.random() * 10) + 1;
    }

    public static int coin() {
        return (int) (Math.random() * 2) + 1;
    }

    public static int advantage20() {
        int a = (int) (Math.random() * 20) + 1;
        int b = (int) (Math.random() * 20) + 1;
        if (a > b)
            return a;
        return b;
    }
}
