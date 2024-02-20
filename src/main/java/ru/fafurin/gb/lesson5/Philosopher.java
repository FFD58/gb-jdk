package ru.fafurin.gb.lesson5;

public class Philosopher extends Thread {
    private final Object leftFork;
    private final Object rightFork;

    private int snacks = 0;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action + " (покушал " + snacks + " раз)");
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    @Override
    public void run() {
        try {
            while (snacks < 3) {
                doAction("думает");
                synchronized (leftFork) {
                    doAction("взял вилку в левую руку");
                    synchronized (rightFork) {
                        doAction("взял вилку в правую руку и кушает спагетти...");
                        doAction("положил на стол вилку из правой руки");
                        snacks++;
                    }
                    doAction("положил на стол вилку из левой руки, думает...");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
