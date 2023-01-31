package com.app.runnables;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created By:  Gyanendra_Yadav
 * on 2023-01-31,Jan,2023
 * in Project: JavaEEConcurrency
 */
public class LoggingProcessor implements Runnable{

    @Override
    public void run() {

        Logger.getLogger(LoggingProcessor.class.getName()).log(Level.INFO, "Logging Data Processing..............................................");
    }
}
