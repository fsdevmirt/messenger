package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;


/**
 * Created by Frank on 04/05/2016.
 */
public class ModelServer extends Observable {

    private List<ModelServerMessageToString> windowMessage;

    public ModelServer() {
        this.windowMessage = new ArrayList<ModelServerMessageToString>();
    }

    public void add(ModelServerMessageToString mess) {
      //  this.windowMessage.add(mess);
        this.setChanged();
        this.notifyObservers(mess);
    }


}
