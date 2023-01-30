package com.app.bean;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-27,Jan,2023
 * in Project: JavaEnterpriseEditionConcurrencyAPI
 */
public class BankAccount {
    private int accountNumber;
    private String accountUserName;
    private String email;
    private String accountType;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String accountUserName) {
        this.accountUserName = accountUserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
