package model;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by Frank on 13/05/2016.
 */
public class ModelClient implements Runnable {

    protected String nickName;
    protected String serverHost;
    protected String serverPort;
    private boolean connected;
    private List<String> messageHistory;

    private static Socket clientSocket = null;
    private static DataOuputStream out = null;
    private static DataInputStream in = null;
    private static BufferedReader inputLine = null;
    private static boolean closed = false;

    public ModelClient() {
        connected = false;
        this.messageHistory = new ArrayList<String>();


        if (clientSocket != null && out != null && in != null) {
            try {

                new Thread(new ModelClient()).start();
                while (!closed) {
                    out.writeBytes(inputLine.readLine().trim());
                }
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }

    private void archiveMessage(String mess) {
        this.messageHistory.add(mess);

    }

    public void connect(String serverHost, String serverPort, String nickName) throws IOException {

        if (!connected) {
            this.nickName = nickName;
            this.serverHost = serverHost;
            this.serverPort = serverPort;

            try {
                clientSocket = new Socket(serverHost, Integer.parseInt(serverPort));
                inputLine = new BufferedReader(new InputStreamReader(System.in));
                out = new DataOuputStream(clientSocket.getOutputStream());
                in = new DataInputStream(clientSocket.getInputStream());
            } catch (IOException e) {
                System.err.println("Communication avec le serveur " + serverHost + " sur le port" + serverPort + " impossible");
            }
        }


    }

    public void disconnect () {
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendServer(String messageSend) throws IOException {


        archiveMessage(messageSend);

    }

    public void receiceServer() {

    }

    @Override
    public void run() {
        String messageReceive;
        try {
            while ((messageReceive = in.readLine()) != null) {
                System.out.println(messageReceive);
                archiveMessage(messageReceive);
                if (messageReceive.indexOf("*** Bye") != -1)
                    break;
            }
            closed = true;
        } catch (IOException e) {
            System.err.println("IOException:  " + e);
        }
    }
   /* public String getMessageReceive() {
        return this.messageReceive.getText();
    } */
}