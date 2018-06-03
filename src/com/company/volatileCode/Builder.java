package com.company.volatileCode;

/**
 * Created by sachin on 23/4/18.
 */
public class Builder {


  volatile int counter=0;
//        int counter=0;

    public static void main(String[] args) {

        Builder builder= new Builder();
        //simply increase counter
        new Thread(new Setter(builder)).start();
        // print counter only once via checking by old value
        new Thread(new Getters(builder)).start();

    }

}
