package com.company.volatileCode;

/**
 * Created by sachin on 23/4/18.
 */
public class Setter implements Runnable {

    Builder builder;

    Setter(Builder builder){
        this.builder= builder;
    }

    @Override
    public void run() {


        for (int i = 0; i < 1000; i++) {
                builder.counter=i;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

}
