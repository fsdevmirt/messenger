package model;

/**
 * Created by Frank on 14/05/2016.
 */
public class ModelServerMessageToString {
    private  String nickName;
    private  String messageSend;

    public ModelServerMessageToString(String nickName, String messageSend) {
        this.nickName=nickName;
        this.messageSend=messageSend;
    }

 public String toString() {   return nickName + ": " + messageSend;
    }
}
