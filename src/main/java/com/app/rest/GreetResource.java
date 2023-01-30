package com.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-25,Jan,2023
 * in Project: JavaEEConcurrency
 */
@Path("greetUser")
public class GreetResource {

    @GET
    public String greetUser(){
        return "Java EEConcurrency Starts......EEConcurrency..........................................................";
    }
}
