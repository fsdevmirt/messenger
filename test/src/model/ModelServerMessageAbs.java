package model;

/**
 * Created by Frank on 14/05/2016.
 */

abstract public class ModelServerMessageAbs implements ModelServerMessage {
    private String messageSend;
    private String nickName;

    public ModelServerMessageAbs(String nickName, String messageSend) {
        this.nickName = nickName;
        this.messageSend = messageSend;


    }
    public String getNickName() {
        return this.nickName;
    }
    public String getMessageSend() {
        return this.messageSend;
    }


}


