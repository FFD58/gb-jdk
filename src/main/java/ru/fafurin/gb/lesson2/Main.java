package ru.fafurin.gb.lesson2;

import ru.fafurin.gb.lesson2.client.ClientGUI;
import ru.fafurin.gb.lesson2.server.FileStorage;
import ru.fafurin.gb.lesson2.server.ServerGUI;
import ru.fafurin.gb.lesson2.server.StorageRepository;

public class Main {
    public static void main(String[] args) {
        StorageRepository fileRepository = new FileStorage();
        ServerGUI serverWindow = new ServerGUI(fileRepository);
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}