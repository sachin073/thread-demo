package com.company.volatileCode;

/**
 * Created by sachin on 23/4/18.
 */
public class Getters implements Runnable{

    Builder builder;
    Getters(Builder builder){
        this.builder= builder;
    }

    @Override
    public void run() {
        int old=0;
        while (builder.counter > -1 && builder.counter < 999 ){
            if (builder.counter != old) {
                System.out.println(builder.counter);
                old = builder.counter;
            }
        }


    }
}
