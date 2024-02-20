package ru.fafurin.gb.lesson4;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(int id) {
        super("Employee with id " + id + " not found");
    }

    public EmployeeNotFoundException(String name) {
        super("Employee with name " + name + " not found");
    }

    public EmployeeNotFoundException(short experience) {
        super("Employee with experience " + experience + " not found");
    }
}
