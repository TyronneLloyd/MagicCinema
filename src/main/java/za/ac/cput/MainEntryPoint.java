package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.ui.UILogin;
import za.ac.cput.ui.admin.UIAdminDashboard;
import za.ac.cput.ui.admin.UIAdminStorage;
import za.ac.cput.ui.admin.UIEmployee;
import za.ac.cput.ui.employee.UIDashboard;


@SpringBootApplication
public class MainEntryPoint {
    public static void main(String[] args) {
        SpringApplication.run(MainEntryPoint.class, args);
        //new UIAdminDashboard();
        //new UIAdminStorage();
        //new UINotification("Record has been added.").SuccessfulNotification();
        //Employee employee = EmployeeFactory.createEmployee("Ty","Lloyd", "Ty@gmail.com",215141210, "Administrator" );
        //new UIEmployeeUpdate(employee, 300, 400);

       // new UIEmployee();

        //GenericHelper.createUserTracker("Jeff");
        //GenericHelper.getUserName();

        //new UILogin();

        //new UIAdminDashboard();

        //new UIDashboard();

    }
}
