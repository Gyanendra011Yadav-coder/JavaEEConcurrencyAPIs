package com.app.runnables;


import com.app.bean.BankAccount;
import com.app.bean.BankAccountTxn;
import com.app.dao.BankAccountDao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-27,Jan,2023
 * in Project: JavaEnterpriseEditionConcurrencyAPI
 */
public class reportProcessor implements Callable<Boolean> {

    private BankAccount bankAccount;
    private BankAccountDao bankAccountDao;


    public reportProcessor(BankAccount bankAccount, BankAccountDao bankAccountDao) {
        this.bankAccount = bankAccount;
        this.bankAccountDao = bankAccountDao;
    }

    public Boolean call() throws Exception {

        Boolean isReportGenerated=false;
        List<BankAccountTxn> txns=bankAccountDao.getTxnForAccount(bankAccount);

        //Saving file with Unique_Name, Therefore Appending Account number to the name of the file
        File file = new File("C:\\Users\\Gyanendra-Yadav\\OneDrive\\Documents\\NetBeansProjects\\JavaEEConcurrency\\UsersTxnGeneratedPDF"+bankAccount.getAccountNumber()+"_txn_reposrt.txt");
 
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
        for (BankAccountTxn txn: txns){
                writer.write("Account Number:"+ txn.getAccountNum());
                writer.write("Account_Type:"+ txn.getTxnType());
                writer.write("Txn_Id"+txn.getTxnId());
                writer.write("Amount:"+txn.getAmount());
                writer.write("Transaction_Date:"+ txn.getDate());

                writer.newLine();
            }
            writer.flush();
            isReportGenerated=true;
        }
        return isReportGenerated;
    }
}
