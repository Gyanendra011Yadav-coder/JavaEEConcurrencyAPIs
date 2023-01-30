package com.app.rest;

import com.app.bean.BankAccount;
import com.app.dao.BankAccountDao;
import com.app.runnables.reportProcessor;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-27,Jan,2023
 * in Project: JavaEEConcurrency
 */
@Path("reports")
public class ReportsResource {

    private BankAccountDao bankAccountDao;
    @Resource(lookup = "java:comp/DefaultManagedExecutorService")

    private ManagedExecutorService executorService;



    public ReportsResource() throws NamingException, PropertyVetoException {

//        InitialContext context = new InitialContext();
//        ManagedExecutorService executorService= (ManagedExecutorService) context.lookup("java:comp/DefaultManagedExecutorService");


        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        bankAccountDao=new BankAccountDao(dataSource);
    }

    @GET
    public String generateReports() throws SQLException, ExecutionException, InterruptedException {
        List<BankAccount> bankAccountList=bankAccountDao.getAllBankAccounts();

        for(int i=0;i<bankAccountList.size();i++){
            System.out.println("Getting bank account..." +i+")"+bankAccountList.get(i).getAccountNumber());
            System.out.println(bankAccountList.get(i).getAccountType());
            System.out.println(bankAccountList.get(i).getAccountUserName());
            System.out.println(bankAccountList.get(i).getEmail());

        }
        //System.out.println("Getting bank accounts..."+ Arrays.toString(bankAccountList.toArray()));
        for(BankAccount bankAccount : bankAccountList){
            System.out.println("Processing for bank account " + bankAccount);
            Future<Boolean> future=executorService.submit(new reportProcessor(bankAccount,bankAccountDao));

            System.out.println("Reports generated: " + future.get());

        }
        return "Reports Generation tasks completed successfully................................................................";
    }
}
