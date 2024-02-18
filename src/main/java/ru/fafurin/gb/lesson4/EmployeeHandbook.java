package ru.fafurin.gb.lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeHandbook {
    ArrayList<Employee> employees = new ArrayList<>();

// метод добавление нового сотрудника в справочник
    public void addEmployee(Employee employee) {
        if (employee != null) {
            this.employees.add(employee);
        }
    }

// метод, который ищет сотрудника по табельному номеру
    public Employee getEmployeeById(int id) {
        Employee result = null;
        for (Employee employee : this.employees) {
            if (employee.getId() == id) result = employee;
        }
        if (result == null) throw new EmployeeNotFoundException(id);
        return result;
    }

// метод, который ищет сотрудника по стажу (может быть список)
    public ArrayList<Employee> getEmployeesByExperience(short experience) {
        ArrayList<Employee> resultList = new ArrayList<>();
        for (Employee employee : this.employees) {
            if (employee.getExperience() == experience) resultList.add(employee);
        }
        if (resultList.isEmpty()) throw new EmployeeNotFoundException(experience);
        return resultList;
    }

// метод, который возвращает номер телефона сотрудника по имени (может быть список)
    public Map<String, String> getEmployeesByName(String name) {
        Map<String, String> resultMap = new HashMap<>();
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) resultMap.put(employee.getPhone(), employee.getName());
        }
        if (resultMap.isEmpty()) throw new EmployeeNotFoundException(name);
        return resultMap;
    }
}
