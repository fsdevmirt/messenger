package controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import model.ModelClient;
import view.ViewConnection;
import view.ViewMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Frank on 13/05/2016.
 */
public class ControllerClient {
    protected ViewMain viewMain;
    protected ModelClient modelClient;

    public ControllerClient() {
        this.viewMain = new ViewMain();
        this.viewMain.setMenuItemConnectActionListener(new ActionConnect());
        this.viewMain.setSendActionListener(new ActionSend());
        this.modelClient = new ModelClient();
        this.viewMain.setVisible(true);
    }

    public class ActionConnect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ControllerConnection controllerConnection = new ControllerConnection(ControllerClient.this.modelClient);


        }
    }

    public class ActionDisconnect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ControllerClient.this.modelClient.disconnect();
        }
    }

    public class ActionCancel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //cancel();
        }
    }

    public class ActionSend implements ActionListener  {
        protected ViewConnection viewConnection;

        public void actionPerformed(ActionEvent e) {

            String mess = ControllerClient.this.viewMain.getMessage();


            try {
                ControllerClient.this.modelClient.sendServer(mess);
                ControllerClient.this.viewMain.addMessageToList(mess);
            } catch (IOException e1) {
                e1.printStackTrace();
                ControllerClient.this.viewMain.addMessageToList("Erreur d'envoi au serveur: "+mess);
            }

            ControllerClient.this.viewMain.emptyMessage();

        }

    }
}
