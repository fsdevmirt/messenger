package model;

/**
 * Created by Frank on 14/05/2016.
 */
public class ModelChannelMessageToString extends ModelChannelMessageAbs {
    public ModelChannelMessageToString(String pseudo, String messageSend) {
        super(pseudo, messageSend);
    }

    public String toString() {
        return this.getPseudo() + ": " + this.getMessageSend();
    }
}
