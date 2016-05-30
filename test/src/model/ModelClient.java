package model;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Frank on 13/05/2016.
 */
public class ModelClient  {

    protected String nickName;
    protected Socket clientSocket;
    private List<String> messageHistory;

    public ModelClient() {

        this.messageHistory = new ArrayList<String>();
    }

    private void archiveMessage(String mess) {
        this.messageHistory.add(mess);

    }

    public void connect(String serverHost, String serverPort, String nickName) throws Exception {
        this.nickName = nickName;
        clientSocket = new Socket(serverHost, Integer.parseInt(serverPort));

    }


    public void send(JTextField messageSend) {
        ModelServerMessageToString newMessage;
        newMessage = new ModelServerMessageToString(nickName, messageSend.getText());
        messageSend.setText("");
        //  windowMessage.add(newMessage);

    }

    public void sendServer(String messageSend) {
        try {

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            outToServer.writeBytes(messageSend + '\n');

        } catch (IOException e) {
            e.printStackTrace();
        }
        archiveMessage(messageSend);

    }


}
