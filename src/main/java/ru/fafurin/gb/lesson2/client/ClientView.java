package ru.fafurin.gb.lesson2.client;

public interface ClientView {
    void sendMessage(String message);
    void connectedToServer();
    void disconnectedFromServer();
    void answerFromServer(String text);
}
