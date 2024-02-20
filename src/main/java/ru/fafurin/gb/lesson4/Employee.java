package ru.fafurin.gb.lesson4;

public class Employee {
    private int id;
    private String name;
    private short experience;
    private String phone;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public String getPhone() {
        return phone;
    }

    public Employee(int id, String name, short experience, String phone) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("id: %s\nname: %s\nphone: %s\nexperience: %s years",
                this.id, this.name, this.phone, this.experience);
    }
}
