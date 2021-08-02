package za.ac.cput.util.ui;

import javax.swing.*;
import java.awt.*;

public class UIPromptNotification {

    private static JFrame f;

    public static void confirmationPrompt() {


        JOptionPane op = new JOptionPane("message", JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        op.setOpaque(true);
        op.setBackground(Color.BLACK);
        op.createDialog(null, "Titel").setVisible(true);


    }

}
