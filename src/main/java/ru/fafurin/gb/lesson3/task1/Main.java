package ru.fafurin.gb.lesson3.task1;

// Урок 3. Обобщенное программирование
public class Main {
    public static void main(String[] args) {
        // 1. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
        // sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
        System.out.println(Calculator.sum(2.3, 3.2323));
        System.out.println(Calculator.subtract(2.3, 3.2323));
        System.out.println(Calculator.multiply(2.3, 3.2323));
        System.out.println(Calculator.divide(2.3, 3.2323));
    }
}
