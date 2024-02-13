package ru.fafurin.gb.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {

    private ServerWindow serverWindow;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    public final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));

    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField();
    private final JPasswordField tfPassword = new JPasswordField("qwerty");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    public final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    static String logs;

    public ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);

        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);

        add(scrollLog);
        setVisible(true);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWindow.serverRunning) {
                    log.append(logs);
                    String message = tfLogin.getText() + ": " + tfMessage.getText() + "\n";
                    sendMessage(message);
                    tfMessage.setText("");
                    serverWindow.refreshLogs();
                    refreshLogs();
                } else {
                    log.append("Server not running\n");
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!serverWindow.serverRunning) {
                    log.append("Server not running\n");
                } else {
                    getLogs();
                    log.append(logs);
                    log.append("You are successful logged in\n");
                    panelTop.setVisible(false);
                }
            }
        });
    }

    private void sendMessage(String message) {
        serverWindow.receiveMessage(message);
        serverWindow.readFileToString();
    }

    private void getLogs() {
        logs = serverWindow.getLogs();
    }

    public void refreshLogs() {
        log.selectAll();
        log.replaceSelection("");
        getLogs();
        log.setText(logs);
    }

}


