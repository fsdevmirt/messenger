package model;

/**
 * Created by Frank on 14/05/2016.
 */

abstract public class ModelChannelMessageAbs implements ModelChannelMessage {
    private String messageSend;
    private String pseudo;

    public ModelChannelMessageAbs(String messageSend, String pseudo) {
        this.messageSend = messageSend;

        this.pseudo = pseudo;
    }

    public String getMessageSend() {
        return this.messageSend;
    }

    public String getPseudo() {
        return this.pseudo;
    }
}


