package com.app.dao;

import com.app.bean.BankAccount;
import com.app.bean.BankAccountTxn;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-27,Jan,2023
 * in Project: JavaEnterpriseEditionConcurrencyAPI
 */
public class BankAccountDao {

    private DataSource dataSource;

    public BankAccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //This method will return bank accounts
    public List<BankAccount> getAllBankAccounts() throws SQLException {
        Connection connectionObj=dataSource.getConnection();

        List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

        BankAccount account = null;

        Statement statement= connectionObj.createStatement();

        ResultSet set = statement.executeQuery("select * from bankaccount");

        while(set.next()) {
            account=new BankAccount();

            account.setAccountNumber(set.getInt("acc_number"));
            account.setAccountUserName(set.getString("acc_holder_name"));
            account.setAccountType(set.getString("acc_type"));
            account.setEmail(set.getString("acc_email"));

            bankAccounts.add(account);
        }
        return bankAccounts;
    }


    //This method is going to return the account txns that are done
    public List<BankAccountTxn> getTxnForAccount(BankAccount account) throws SQLException {

        Connection connectionObj=dataSource.getConnection();

        BankAccountTxn transaction=null;

        List<BankAccountTxn>  bankAccounts = new ArrayList<BankAccountTxn>();

        PreparedStatement statement=connectionObj.prepareStatement("select * from bankaccounttxn where acc_number=?");

        statement.setInt(1, account.getAccountNumber());

        ResultSet set=statement.executeQuery();

        while(set.next()){
            transaction=new BankAccountTxn();

            transaction.setAccountNum(set.getInt("acc_number"));
            transaction.setAmount(set.getDouble("acc_amount"));
            transaction.setDate(new Date(set.getDate("transaction_date").getTime()));
            transaction.setTxnId(set.getInt("txn_id"));
            transaction.setTxnType(set.getString("transaction_type"));

            bankAccounts.add(transaction);
        }

        return bankAccounts;
    }
}
