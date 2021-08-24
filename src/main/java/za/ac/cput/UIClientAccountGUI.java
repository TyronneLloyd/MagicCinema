package za.ac.cput;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.ui.clientaccount.admin.UIAdminClientAccount;


@SpringBootApplication
public class UIClientAccountGUI {
    public static void main(String[] args) {
        new UIAdminClientAccount();



    }
}
