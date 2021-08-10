package za.ac.cput.entity;

/*  @Subject: Project 3
    @Description: Employees Entity -> Employee.java
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 3rd June 2021
  */
public class Employee {
    private String employeeNumber, name, surname, email, userType, dateCreated;
    private int password;

    private Employee(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.userType = builder.userType;
        this.dateCreated = builder.dateCreated;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber='" + employeeNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userType='" + userType + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }

    public static class Builder{
        private String employeeNumber, name, surname, email, userType, dateCreated;
        private int password;

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
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setUserType(String userType){
            this.userType = userType;
            return this;
        }
        public Builder setPassword(int password){
            this.password = password;
            return this;
        }
        public Builder setDateCreated(String dateCreated){
            this.dateCreated = dateCreated;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }

        public Builder copy(Employee employee){
            this.employeeNumber = employee.employeeNumber;
            this.name = employee.name;
            this.surname = employee.surname;
            this.email = employee.email;
            this.password = employee.password;
            this.userType = employee.userType;
            this.dateCreated = employee.dateCreated;
            return this;
        }

    }//Inner Class
    public String getEmployeeNumber() {return employeeNumber;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEmail() {return email;}
    public String getUserType() {
        return userType;
    }
    public int getPassword() {return password;}
    public String getDateCreated() {return dateCreated;}
}// Outer Class
