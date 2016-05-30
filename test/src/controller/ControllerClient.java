package controller;

import model.ModelClient;
import view.ViewConnection;
import view.ViewMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            //disconnect();
        }
    }

    public class ActionCancel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //cancel();
        }
    }

    public class ActionSend implements ActionListener {
        protected ViewConnection viewConnection;

        public void actionPerformed(ActionEvent e) {
            // test de passage du message au controlleur
            String mess = ControllerClient.this.viewMain.getMessage();
            System.out.println(mess);

            ControllerClient.this.modelClient.sendServer(mess);
            ControllerClient.this.viewMain.addMessageToList(mess);
            ControllerClient.this.viewMain.emptyMessage();

        }

    }
}
