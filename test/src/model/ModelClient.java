package model;

import java.util.Observable;

/**
 * Created by Frank on 13/05/2016.
 */
public class ModelClient extends Observable {
private ModelChannel channel;

    public ModelClient(ModelChannel channel, String pseudo ) {
this.channel = channel;




    }
}
