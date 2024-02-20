package ru.fafurin.gb.lesson2.client;

import ru.fafurin.gb.lesson2.server.ServerView;

public class Client {
    private ClientView clientView;
    private String name;
    private boolean connected;
    private ServerView serverView;

    public Client(ClientView clientView, ServerView serverView) {
        this.clientView = clientView;
        this.serverView = serverView;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (serverView.connectUser(clientView)) {
            showOnWindow("Вы успешно подключились!\n");
            connected = true;
            String log = serverView.getLog();
            if (log != null) {
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }

    private void showOnWindow(String text){
        clientView.sendMessage(text + "\n");
    }

    public void answerFromServer(String text){
        showOnWindow(text);
    }

    public void sendMessage(String text){
        if (connected){
            if (!text.isEmpty()){
                serverView.message(name + ": " + text);
            }
        } else {
            showOnWindow("Нет подключения к серверу");
        }
    }

    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            clientView.disconnectedFromServer();
            serverView.disconnectUser(clientView);
            showOnWindow("Вы были отключены от сервера!");
        }
    }

}
