package ru.fafurin.gb.lesson2.server;

public interface StorageRepository {
    String readLog();
    void saveInLog(String text);
}
