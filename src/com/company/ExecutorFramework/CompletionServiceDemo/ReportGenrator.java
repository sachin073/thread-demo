package com.company.ExecutorFramework.CompletionServiceDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by sachin on 17/7/18.
 */
public class ReportGenrator implements Callable<String> {

    String title;
    String sender;

    public ReportGenrator(String title, String name) {
        this.title = title;
        this.sender = name;
    }

    @Override
    public String call() throws Exception {
        try {
            Long duration=(long)(Math.random()*10);
            System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n",this.sender,this.title,duration);
                    TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return title+" > "+ sender;
    }


}
