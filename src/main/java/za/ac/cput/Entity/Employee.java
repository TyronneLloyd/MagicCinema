package za.ac.cput.Entity;
/*  @Subject: Project 3
    @Description: Employees Entity -> Employee.java
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 3rd June 2021
 */
public class Employee {
    private String employeeNumber, name, surname, userType, username, password;

    private Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.name = builder.name;
        this.surname = builder.surname;
        this.userType = builder.userType;
        this.username = builder.username;
        this.password = builder.password;
    }
    @Override
    public String toString() {
        return "Employee" +
                "Number ='" + employeeNumber + '\'' +
                ", name= '" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", userType ='" + userType + '\'' +
                ", username ='" + username + '\'' +
                ", password ='" + password + '\''
                ;
    }

    public static class Builder{
        private String employeeNumber, name, surname, userType, username, password;

        public Builder setEmployeeNumber(String employeeNumber){
            this.employeeNumber = employeeNumber;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder setUserType(String userType){
            this.userType = userType;
            return this;
        }
        public Builder setUsername(String username){
            this.username = username;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }

        private Builder copy(Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.name = employee.name;
            this.surname = employee.surname;
            this.userType = employee.userType;
            this.username = employee.username;
            this.password = employee.password;
            return this;
        }
    }//Inner Class
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getUserType() {
        return userType;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}// Outer Class
