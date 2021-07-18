package za.ac.cput.Util.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPromptNotification {

    private static JFrame f;

    public static void confirmationPrompt() {


        JOptionPane op = new JOptionPane("message", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        op.setOpaque(true);
        op.setBackground(Color.BLACK);
        op.createDialog(null, "Titel").setVisible(true);


    }

}
