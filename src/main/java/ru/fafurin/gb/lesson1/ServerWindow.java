package ru.fafurin.gb.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;

    private static final String SERVER_START = "The server is running!";

    private static final String SERVER_STOP = "The server is stopped!";

    private JButton btnStart, btnStop;

    public final JTextArea log = new JTextArea();

    public boolean serverRunning = false;

    private String logs;

    private final String logFileName = "log.txt";

    public ServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("The most powerful server");
        setResizable(false);

        this.btnStart = new JButton("Start");
        this.btnStop = new JButton("Stop");

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(btnStart);
        bottomPanel.add(btnStop);
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel topPanel = new JPanel(new GridLayout(1, 1));
        JLabel start = new JLabel(SERVER_STOP);
        topPanel.add(start);
        add(topPanel, BorderLayout.NORTH);

        JPanel logPanel = new JPanel(new GridLayout(1, 1));
        log.setBackground(Color.white);
        logPanel.add(log);
        add(logPanel, BorderLayout.CENTER);

        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setText(SERVER_START);
                readFileToString();
                log.append(logs);
                repaint();
                serverRunning = true;
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setText(SERVER_STOP);
                serverRunning = false;
                log.selectAll();
                log.replaceSelection("");
            }
        });

    }

    public String getLogs() {
        return logs;
    }

    public void clearLog() {
        try {
            new FileWriter(logFileName, false).close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void receiveMessage(String message) {
        if (serverRunning) {
            try {
                FileWriter writer = new FileWriter(this.logFileName, true);
                writer.write(message);
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void refreshLogs() {
        log.selectAll();
        log.replaceSelection("");
        readFileToString();
        log.append(logs);
    }

    public void readFileToString() {
        try {
            this.logs = new String(Files.readAllBytes(Paths.get(this.logFileName)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
