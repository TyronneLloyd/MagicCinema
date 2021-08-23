package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.ac.cput.ui.customer.UICustomer;
import za.ac.cput.ui.dashboard.admin.UIAdminDashboard;
import za.ac.cput.ui.dashboard.sales.UIDashboard;
import za.ac.cput.ui.employee.AddEmployeeGUI;
import za.ac.cput.ui.storage.UIAdminStorage;


@SpringBootApplication
public class MainEntryPoint {
    public static void main(String[] args) {
       // UIDashboard dashboard = new UIDashboard();
        //SpringApplication.run(MainEntryPoint.class, args);
        new UIAdminDashboard();
        new UIAdminStorage();
        new UICustomer();

        //new UINotification("Record has been added.").SuccessfulNotification();
        //Employee employee = EmployeeFactory.createEmployee("Ty","Lloyd", "Ty@gmail.com",215141210, "Administrator" );
        //new UIEmployeeUpdate(employee, 300, 400);

       // new UIEmployee();

        //GenericHelper.createUserTracker("Jeff");
        //GenericHelper.getUserName();

        //new UILogin();

        //new UIAdminDashboard();



    }
}
