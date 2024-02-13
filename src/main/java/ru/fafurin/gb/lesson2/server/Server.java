package ru.fafurin.gb.lesson2.server;

import ru.fafurin.gb.lesson2.client.ClientView;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public StorageRepository storageRepository;

    private List<ClientView> clientViewList;
    private ServerView serverView;
    private boolean work;
    public Server(ServerView serverView, StorageRepository storageRepository) {
        this.serverView = serverView;
        this.storageRepository = storageRepository;
        this.clientViewList = new ArrayList<>();
    }

    public List<ClientView> getClientViewList() {
        return clientViewList;
    }

    public boolean connectUser(ClientView clientView){
        if (!work){
            return false;
        }
        clientViewList.add(clientView);
        return true;
    }

    public void disconnectUser(ClientView client){
        clientViewList.remove(client);
        if (client != null){
            client.disconnectedFromServer();
        }
    }

}
