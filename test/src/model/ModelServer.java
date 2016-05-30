package model;

import java.io.DataOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;


/**
 * Created by Frank on 04/05/2016.
 */
public class ModelServer extends Observable {

    private List<String> windowMessage;

    public ModelServer() {
        this.windowMessage = new ArrayList<String>();
    }

    public void add(String mess) {
       this.windowMessage.add(mess);
        //DataOutputStream outToServer = new DataOutputStream(ModelClient.this.clientSocket.getOutputStream());
        this.setChanged();
        this.notifyObservers(mess);
    }


}
