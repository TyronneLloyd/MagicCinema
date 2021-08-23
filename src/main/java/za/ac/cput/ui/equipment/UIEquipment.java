package za.ac.cput.ui.equipment;
import za.ac.cput.ui.equipment.equipmentActions.UIEquipmentAdd;
import za.ac.cput.ui.equipment.equipmentActions.UIEquipmentDelete;
import za.ac.cput.ui.equipment.equipmentActions.UIEquipmentUpdate;
import za.ac.cput.ui.equipment.storageActions.UIStorageLocationAdd;
import za.ac.cput.ui.equipment.storageActions.UIStorageLocationDelete;
import za.ac.cput.ui.equipment.storageActions.UIStorageLocationUpdate;
import za.ac.cput.ui.general.AdminSideNavigationBar;
import za.ac.cput.util.GenericHelper;
/*  @Subject: Project 3
    @Description: Employees Entity -> Employee.java
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: August 2021
  */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class UIEquipment extends JFrame {

        private JMenuBar mainMenu, buttonMenu, buttonMenu1;
        private ImageIcon iconLogo;
        private JLabel lblTitle, lblCurrentUser, lblHeadingStorage, lblHeadingEquipment;
        private static JTable table,equipmentPanelTable;
        private static DefaultTableModel model, equipmentPanelModel;
        private JScrollPane pane,pane0;

        public UIEquipment() {
            super("❣ Admin Storage Management");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Color navColor = new Color(186,39,94);
            Color headingText = new Color(230, 196, 96);
            Color textColor = Color.WHITE;

            String userInfo = GenericHelper.getUserName();

            JPanel panelMainStorage = new JPanel(new GridLayout(2, 0));
            panelMainStorage.setSize(new Dimension(1000, 60));
            panelMainStorage.setBorder(new EmptyBorder(10, 10, 10, 10));
            panelMainStorage.setBackground(Color.WHITE);

            buttonMenu = new JMenuBar();
            buttonMenu.setOpaque(true);
            buttonMenu.setBackground(Color.WHITE);
            buttonMenu.add(Box.createHorizontalGlue());

            JButton btnUpdate = new JButton("Update");
            btnUpdate.setBackground(navColor);
            btnUpdate.setForeground(textColor);
            btnUpdate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int x = getSize().width / 2;
                    int y = getSize().height / 2;
                    new UIStorageLocationUpdate(x, y);
                }
            });

            JButton btnAdd = new JButton("Add");
            btnAdd.setBackground(navColor);
            btnAdd.setForeground(textColor);
            btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int x = getSize().width / 2;
                    int y = getSize().height / 2;
                    new UIStorageLocationAdd(x, y);
                }
            });

            JButton btnDelete = new JButton("Delete");
            btnDelete.setBackground(navColor);
            btnDelete.setForeground(textColor);
            btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int x = getSize().width / 2;
                    int y = getSize().height / 2;
                    new UIStorageLocationDelete(x, y);
                }
            });

            JButton btnReload = new JButton("Reload");
            btnReload.setBackground(navColor);
            btnReload.setForeground(textColor);

            buttonMenu.add(btnUpdate);
            buttonMenu.add(btnAdd);
            buttonMenu.add(btnDelete);
            buttonMenu.add(btnReload);


            JPanel panelMainEquipment = new JPanel(new GridLayout(2, 0));
            panelMainEquipment.setSize(new Dimension(1000, 60));
            panelMainEquipment.setBorder(new EmptyBorder(10, 10, 10, 10));
            panelMainEquipment.setBackground(Color.WHITE);

            buttonMenu1 = new JMenuBar();
            buttonMenu1.setOpaque(true);
            buttonMenu1.setBackground(Color.WHITE);
            buttonMenu1.add(Box.createHorizontalGlue());

            JButton btnUpdate1 = new JButton("Update");
            btnUpdate1.setBackground(navColor);
            btnUpdate1.setForeground(textColor);
            btnUpdate1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int x = getSize().width / 2;
                    int y = getSize().height / 2;
                    new UIEquipmentUpdate(x, y);
                }
            });

            JButton btnAdd1 = new JButton("Add");
            btnAdd1.setBackground(navColor);
            btnAdd1.setForeground(textColor);
            btnAdd1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int x = getSize().width / 2;
                    int y = getSize().height / 2;
                    new UIEquipmentAdd(x, y);
                }
            });

            JButton btnDelete1 = new JButton("Delete");
            btnDelete1.setBackground(navColor);
            btnDelete1.setForeground(textColor);
            btnDelete1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int x = getSize().width / 2;
                    int y = getSize().height / 2;
                    new UIEquipmentDelete(x, y);
                }
            });


            JButton btnReload1 = new JButton("Reload");
            btnReload1.setBackground(navColor);
            btnReload1.setForeground(textColor);

            buttonMenu1.add(btnUpdate1);
            buttonMenu1.add(btnAdd1);
            buttonMenu1.add(btnDelete1);
            buttonMenu1.add(btnReload1);

            lblHeadingStorage = new JLabel("Admin Equipment Storage", SwingConstants.LEFT);
            lblHeadingStorage.setForeground(navColor);
            lblHeadingStorage.setFont(new Font("Courier", Font.BOLD,16));
            lblHeadingStorage.setPreferredSize(new Dimension(100, 50));
            lblHeadingStorage.setHorizontalAlignment(SwingConstants.LEFT);
            lblHeadingStorage.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

            panelMainStorage.add(lblHeadingStorage);
            panelMainStorage.add(buttonMenu);

            lblHeadingEquipment = new JLabel("Admin Equipment Management", SwingConstants.LEFT);
            lblHeadingEquipment.setForeground(navColor);
            lblHeadingEquipment.setFont(new Font("Courier", Font.BOLD,16));
            lblHeadingEquipment.setPreferredSize(new Dimension(100, 50));
            lblHeadingEquipment.setHorizontalAlignment(SwingConstants.LEFT);
            lblHeadingEquipment.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

            panelMainEquipment.add(lblHeadingEquipment);
            panelMainEquipment.add(buttonMenu1);

            JPanel nav = new AdminSideNavigationBar(userInfo, "Administrator", "images/employee-icons/person.jpg", "Equipment Management");
            nav.setBackground(navColor);

            //Storage Center Panel
            JPanel panelCenterStorage = new JPanel(new BorderLayout());
            table = new JTable();
            model = new DefaultTableModel();
            Object[] columnsName = new Object[2];
            columnsName[0] = "Location ID";
            columnsName[1] = "Location Name";
            model.setColumnIdentifiers(columnsName);
            table.setModel(model);
            table.getTableHeader().setOpaque(false);
            table.getTableHeader().setBackground(navColor);
            table.getTableHeader().setForeground(Color.WHITE);
            pane = new JScrollPane(table);
            pane.setPreferredSize(new Dimension(1000, 450));
            panelCenterStorage.add(panelMainStorage, BorderLayout.NORTH);
            panelCenterStorage.add(pane,BorderLayout.CENTER);

            //Storage Center Panel
            JPanel equipmentPanel = new JPanel(new BorderLayout());
            equipmentPanelTable = new JTable();
            equipmentPanelModel = new DefaultTableModel();
            Object[] columnEquipmentName = new Object[2];
            columnEquipmentName[0] = "Equipment ID";
            columnEquipmentName[1] = "Equipment Name";
            equipmentPanelModel.setColumnIdentifiers(columnEquipmentName);
            equipmentPanelTable.setModel(equipmentPanelModel);
            equipmentPanelTable.getTableHeader().setOpaque(false);
            equipmentPanelTable.getTableHeader().setBackground(navColor);
            equipmentPanelTable.getTableHeader().setForeground(Color.WHITE);
            pane0 = new JScrollPane(equipmentPanelTable);
            pane0.setPreferredSize(new Dimension(1000, 450));
            equipmentPanel.add(panelMainEquipment, BorderLayout.NORTH);
            equipmentPanel.add(pane0,BorderLayout.CENTER);


            JPanel panelCenter = new JPanel(new GridLayout(2,1));
            panelCenter.add(panelCenterStorage);
            panelCenter.add(equipmentPanel);
            JScrollPane scroll = new JScrollPane(panelCenter);
            scroll.setPreferredSize(new Dimension(1000, 450));
            getContentPane().add(scroll, BorderLayout.CENTER);
            getContentPane().add(nav, BorderLayout.WEST);


            //Display the window.
            setSize(1000, 750);
            pack();
            setVisible(true);
            //setResizable(false);
        }
    }//end

