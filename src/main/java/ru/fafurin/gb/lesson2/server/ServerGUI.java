package ru.fafurin.gb.lesson2.server;

import ru.fafurin.gb.lesson2.client.ClientView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ServerGUI extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private Server server;
    private StorageRepository storageRepository;

    private List<ClientView> clientViewList;

    JButton btnStart, btnStop;
    JTextArea log;
    boolean work;

    public ServerGUI(StorageRepository fileStorage){
        this.storageRepository = fileStorage;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        createPanel();
        setVisible(true);
        server = new Server(this, fileStorage);
        this.clientViewList = server.getClientViewList();
    }

    @Override
    public void disconnectUser(ClientView client) {
        this.server.disconnectUser(client);
    }

    @Override
    public String getLog() {
        return this.storageRepository.readLog();
    }

    public void message(String text){
        if (!work){
            return;
        }
        text += "";
        appendLog(text);
        answerAll(text);
        storageRepository.saveInLog(text);
    }

    @Override
    public boolean connectUser(ClientView clientView) {
        if (!work){
            return false;
        }
        clientViewList.add(clientView);
        return true;
    }

    private void answerAll(String text){
        for (ClientView clientView: clientViewList){
            clientView.answerFromServer(text);
        }
    }

    private void appendLog(String text){
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (work){
                    appendLog("Сервер уже был запущен");
                } else {
                    work = true;
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!work){
                    appendLog("Сервер уже был остановлен");
                } else {
                    work = false;
                    while (!clientViewList.isEmpty()){
                        disconnectUser(clientViewList.get(clientViewList.size()-1));
                    }
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}