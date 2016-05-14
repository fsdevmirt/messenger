package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;


/**
 * Created by Frank on 04/05/2016.
 */
public class ModelChannel extends Observable {

    private List<ModelChannelMessage> windowMessage;

    public ModelChannel() {
        this.windowMessage = new ArrayList<ModelChannelMessage>();
    }

    public void add(ModelChannelMessage mess) {
        this.windowMessage.add(mess);
        this.setChanged();
        this.notifyObservers(mess);
    }


}
