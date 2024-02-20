package ru.fafurin.gb.lesson5;

public class Main {
    public static void main(String[] args) {
        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int x = 0; x < forks.length; x++) {
            forks[x] = new Object();
        }

        for (int x = 0; x < philosophers.length; x++) {
            Object leftFork = forks[x];
            Object rightFork = forks[(x + 1) % forks.length];

            if (x == philosophers.length - 1) {
                philosophers[x] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[x] = new Philosopher(leftFork, rightFork);
            }
            Thread thread = new Thread(philosophers[x], "Философ " + (x + 1));
            thread.start();
        }
    }
}
