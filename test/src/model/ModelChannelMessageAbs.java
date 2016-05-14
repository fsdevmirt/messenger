package model;

/**
 * Created by Frank on 14/05/2016.
 */

abstract public class ModelChannelMessageAbs implements ModelChannelMessage {
    private String texte;
    private String pseudo;

    public ModelChannelMessageAbs(String texte, String pseudo) {
        this.texte = texte;
        this.pseudo = pseudo;
    }

    public String getTexte() {
        return this.texte;
    }

    public String getPseudo() {
        return this.pseudo;
    }
}


