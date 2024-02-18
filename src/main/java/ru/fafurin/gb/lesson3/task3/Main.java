package ru.fafurin.gb.lesson3.task3;

import ru.fafurin.gb.lesson3.task2.Cat;

// Урок 3. Обобщенное программирование
public class Main {
    public static void main(String[] args) {
// 3. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
// Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
// а также переопределение метода toString(), возвращающее строковое представление пары.

        Pair pair = new Pair(new Cat("cat"), "Second");

        System.out.println(pair);

    }
}
