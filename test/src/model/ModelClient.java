package model;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;

/**
 * Created by Frank on 13/05/2016.
 */
public class ModelClient extends Observable {
    private ModelServer windowMessage;
    protected String nickName;

    public void connect(String serverHost, String serverPort,String nickName)throws Exception  {
this.nickName=nickName;
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket(serverHost, Integer.parseInt(serverPort));

    }


    public void send(JTextField messageSend) {
        ModelServerMessageToString newMessage;
        newMessage = new ModelServerMessageToString(nickName, messageSend.getText());
        messageSend.setText("");
        windowMessage.add(newMessage);

    }

    public void sendServer(String messageSend) {
        windowMessage.add(new ModelServerMessageToString(nickName, messageSend));

    }


}
