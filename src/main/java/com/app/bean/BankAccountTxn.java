package com.app.bean;

import java.util.Date;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-27,Jan,2023
 * in Project: JavaEnterpriseEditionConcurrencyAPI
 */
public class BankAccountTxn {

    private int accountNum;
    private double amount;
    private Date date;
    private String txnType;
    private int txnId;

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public int getTxnId() {
        return txnId;
    }

    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }
}
