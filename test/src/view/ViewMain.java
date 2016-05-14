package view;


import model.ModelChannel;
import model.ModelChannelMessage;
import model.ModelChannelMessageToString;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Frank on 12/05/2016.
 */
public class ViewMain extends javax.swing.JFrame implements Observer {
    //Test
   private ModelChannel channel;
    private String pseudo="bob";
    DefaultListModel user = new DefaultListModel();

    //Fin test

    public ViewMain(ModelChannel channel) {
        initComponents();

        this.channel = channel;
        this.channel.addObserver(this);
       //Ajout d'un label avec NickName
        // this.pseudo.setText(pseudo);


    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listUser = new javax.swing.JList<String>(user);
        jScrollPane2 = new javax.swing.JScrollPane();
        windowMessage = new javax.swing.JTextArea();
        messageSend = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConnection = new javax.swing.JMenu();
        menuItemConnect = new javax.swing.JMenuItem();
        menuItemDisconnect = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemExit = new javax.swing.JMenuItem();
        //test listUser
        user.addElement(pseudo);
        listUser.updateUI();
        //Fin test
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NFP Messenger");

        jScrollPane1.setViewportView(listUser);
//version textArea
        windowMessage.setEditable(false);
        windowMessage.setColumns(20);
        windowMessage.setRows(5);
        jScrollPane2.setViewportView(windowMessage);

        send.setText("Send");

        menuConnection.setText("Connection");

        menuItemConnect.setText("Connect");
        menuItemConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConnectActionPerformed(evt);
            }
        });
        menuConnection.add(menuItemConnect);

        menuItemDisconnect.setText("Disconnect");
        menuConnection.add(menuItemDisconnect);
        menuConnection.add(jSeparator1);

        menuItemExit.setText("Exit");
        menuConnection.add(menuItemExit);

        jMenuBar1.add(menuConnection);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(messageSend, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(messageSend)
                                        .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        //MenuItems
        this.menuItemConnect.addActionListener(new

                ActionConnect()

        );
        this.menuItemDisconnect.addActionListener(new

                ActionDisconnect()

        );

        this.menuItemExit.addActionListener(new

                ActionCancel()

        );
        //Envoi du message
        this.send.addActionListener(new

                ActionSend()

        );

    }// </editor-fold>

    private void menuItemConnectActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModelChannel channel = new ModelChannel();
                new ViewMain(channel).setVisible(true);

            }
        });

    }


    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JList<String> listUser;
    private javax.swing.JMenu menuConnection;
    private javax.swing.JMenuItem menuItemConnect;
    private javax.swing.JMenuItem menuItemDisconnect;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JTextField messageSend;
    private javax.swing.JButton send;
    private javax.swing.JTextArea windowMessage;


    @Override
    public void update(Observable o, Object arg) {
//Mise à jour des messages sur le modèle avec retour chariot
        windowMessage.append("" + arg + "\n");
    }


    public class ActionConnect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            connect();
        }
    }

    public class ActionDisconnect implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            disconnect();
        }
    }

    public class ActionCancel implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cancel();
        }
    }

    public class ActionSend implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            send(messageSend);
        }

    }

    public void connect() {
        new ViewConnection().setVisible(true);
    }

    public void disconnect() {


    }

    public void cancel() {
        this.dispose();
    }

    public void send(JTextField messageSend) {
        ModelChannelMessage newMessage;
        newMessage = new ModelChannelMessageToString(pseudo,messageSend.getText());
        messageSend.setText("");
        channel.add(newMessage);
        
    }
    // End of variables declaration
}



