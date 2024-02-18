package ru.fafurin.gb.lesson4;

// Урок 4. Коллекции
public class Main {
    public static void main(String[] args) {
// Создать справочник сотрудников
// Необходимо:
// Создать класс справочник сотрудников, который содержит внутри
// коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
// Табельный номер, Номер телефона, Имя, Стаж
// Добавить метод, который ищет сотрудника по стажу (может быть список)
// Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
// Добавить метод, который ищет сотрудника по табельному номеру
// Добавить метод добавление нового сотрудника в справочник

        EmployeeHandbook handbook = new EmployeeHandbook();
        handbook.addEmployee(new Employee(12312, "Ivanov", (short) 12, "89345678122"));
        handbook.addEmployee(new Employee(10012, "Ivanov", (short) 1, "89347848121"));
        handbook.addEmployee(new Employee(11112, "Petrov", (short) 7, "89111270116"));
        handbook.addEmployee(new Employee(8112, "Smirnov", (short) 3, "87131290312"));

        try {
            System.out.println(handbook.getEmployeesByExperience((short) 7));
            System.out.println(handbook.getEmployeesByName("Ivanov"));
            System.out.println(handbook.getEmployeeById(8112));
            System.out.println(handbook.getEmployeeById(1));

        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}