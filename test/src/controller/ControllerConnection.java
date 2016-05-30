package controller;

import model.ModelClient;
import view.ViewConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Frank on 13/05/2016.
 */
public class ControllerConnection {
    protected ViewConnection viewConnection;
    protected ModelClient modelClient;

    public ControllerConnection(ModelClient modelClient) {
        this.viewConnection = new ViewConnection();
        this.modelClient=modelClient;
        this.viewConnection.setConnectJBActionListener(new ActionConnect());
        this.viewConnection.setVisible(true);
    }
    public class ActionConnect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            /* Test debug
            System.out.print(ControllerConnection.this.viewConnection.getServerHostValue());
            System.out.print(ControllerConnection.this.viewConnection.getPortValue());
            System.out.print(ControllerConnection.this.viewConnection.getNickNameValue());
            */
            try {
                ControllerConnection.this.modelClient.connect(
                        ControllerConnection.this.viewConnection.getServerHostValue(),
                        ControllerConnection.this.viewConnection.getPortValue(),
                        ControllerConnection.this.viewConnection.getNickNameValue()

                );
                ControllerConnection.this.viewConnection.setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }


        }


    }


}