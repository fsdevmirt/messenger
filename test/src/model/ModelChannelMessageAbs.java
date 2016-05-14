package model;

/**
 * Created by Frank on 14/05/2016.
 */

abstract public class ModelChannelMessageAbs implements ModelChannelMessage {
    private String messageSend;
    private String pseudo;

    public ModelChannelMessageAbs(String pseudo, String messageSend) {
        this.pseudo = pseudo;
        this.messageSend = messageSend;


    }
    public String getPseudo() {
        return this.pseudo;
    }
    public String getMessageSend() {
        return this.messageSend;
    }


}


