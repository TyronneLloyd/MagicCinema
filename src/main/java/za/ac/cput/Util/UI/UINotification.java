package za.ac.cput.Util.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class UINotification extends JFrame implements ActionListener {

    private JButton closeButton;


    public UINotification(String message) {
        setSize(300,80);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0f;
        constraints.weighty = 1.0f;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.BOTH;
        JLabel headingLabel = new JLabel(message, SwingConstants.CENTER);
        headingLabel.setOpaque(false);
        add(headingLabel, constraints);
        constraints.gridx++;
        constraints.weightx = 0f;
        constraints.weighty = 0f;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;
        closeButton = new JButton("X");
        closeButton.addActionListener(this);
        closeButton.setMargin(new Insets(1, 4, 1, 4));
        closeButton.setFocusable(false);
        add(closeButton, constraints);

        //getContentPane().setBackground(Color.color);

        setUndecorated(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void ErrorNotification() {

        getContentPane().setBackground(Color.RED);
        closeButton.setBackground(Color.RED);
    }

    public void SuccessfulNotification() {

        getContentPane().setBackground(Color.GREEN);
        closeButton.setBackground(Color.GREEN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("X")) {
            dispose();
        }
    }
}
