package ru.fafurin.gb.lesson2.server;

import ru.fafurin.gb.lesson2.client.ClientView;

public interface ServerView {
    void disconnectUser(ClientView client);

    void message(String text);

    boolean connectUser(ClientView client);
    String getLog();
}
