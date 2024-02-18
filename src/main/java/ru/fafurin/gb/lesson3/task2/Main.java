package ru.fafurin.gb.lesson3.task2;

// Урок 3. Обобщенное программирование
public class Main {
    public static void main(String[] args) {

// 2. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
// если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
        Integer[] arr1 = new Integer[]{4, 2, 123, 4564, 11};
        Integer[] arr2 = new Integer[]{4, 2, 123, 4564, 11};
        Integer[] arr3 = new Integer[]{4, 2, 123, 4564};
        Double[] arr4 = new Double[]{4.231, 2.313111, 1.23, 45.64};
        Double[] arr5 = new Double[]{4.231, 1.313111, 1.23, 45.64};

        System.out.println(compareArrays(arr1, arr2));
        System.out.println(compareArrays(arr1, arr3));
        System.out.println(compareArrays(arr4, arr5));

        Dog dog = new Dog("Dog");
        Cat cat = new Cat("Cat");


        Animal[] animals1 = new Animal[]{dog, cat, dog};
        Animal[] animals2 = new Animal[]{dog, cat, dog};
        Animal[] animals3 = new Animal[]{cat, cat, dog};

        System.out.println(compareArrays(animals1, animals2));
        System.out.println(compareArrays(animals1, animals3));

    }
    private static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        boolean result = false;
        if (arr1.length == arr2.length) {
            for (int x = 0; x < arr1.length; x++) {
                if (!arr1[x].equals(arr2[x])) {
                    result = false;
                    break;
                }
                else result = true;
            }
        }
        return result;
    }
}
