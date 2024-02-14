package ru.fafurin.gb.lesson3.task3;

// 3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
// Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
// а также переопределение метода toString(), возвращающее строковое представление пары.

public record Pair<F, S>(F first, S second) {

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pa{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
