package com.app.rest;

import com.app.runnables.LoggingProcessor;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-31,Jan,2023
 * in Project: JavaEEConcurrency
 */

@Path("logData")
public class LogginResouce {

    @Resource(lookup = "java:comp/DefaultManagedThreadFactory")
    private ManagedThreadFactory managedThreadFactory;

    @GET
    public String logData() {
        Thread thread = managedThreadFactory.newThread(new LoggingProcessor());

        thread.setName("Logging Thread");

        thread.start();

        return "Logging Thread Started!!!!";
    }

}
