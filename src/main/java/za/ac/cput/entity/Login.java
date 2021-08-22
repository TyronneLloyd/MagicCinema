package za.ac.cput.entity;

/*
   @Subject: Project 3
   @Description:Login.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 4 June 2021
*/

public class Login {

    private String password;

    private Login(Builder builder) {
        this.password = builder.password;
    }

    public String getPassword() {return password;}

    public static class Builder
    {
        private String password;
        public Login.Builder Password (String password) {
            this.password = password;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Login build(){
            return new Login(this);
        }

        public Login.Builder copy(Login login)
        {
            this.password = login.password;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Login{" +
                "password='" + password + '\'' +
                '}';
    }
}
