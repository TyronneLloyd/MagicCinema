package za.ac.cput.entity;

/*
   @Subject: Project 3
   @Description:ClientAccount.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 4 June 2021
*/

public class ClientAccount {
    private String accountNumber, numberBorrowed;

    private ClientAccount(Builder builder)
    {
        this.accountNumber = builder.accountNumber;
        this.numberBorrowed = builder.numberBorrowed;
    }

    public String getAccountNumber(){return accountNumber;}

    public String getNumberBorrowed() {
        return numberBorrowed;
    }

    public static class Builder {
        private String accountNumber, numberBorrowed;

        public ClientAccount.Builder NumberBorrowed(String numberBorrowed) {
            this.numberBorrowed = numberBorrowed;
            return this;
        }
        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setNumberBorrowed(String numberBorrowed) {
            this.numberBorrowed = numberBorrowed;
            return this;
        }

        public ClientAccount build(){
            return new ClientAccount(this);
        }

        public ClientAccount.Builder copy(ClientAccount clientAccount)
        {
            this.accountNumber = clientAccount.accountNumber;
            this.numberBorrowed = clientAccount.numberBorrowed;
            return this;
        }
    }

    @Override
    public String toString()
    {
        return "ClientAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", numberBorrowed='" + numberBorrowed + '\'' +
                '}';
    }
}
