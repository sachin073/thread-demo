package com.company.localThread;

import java.util.Map;

/**
 * Created by sachin on 2/6/18.
 */
public class SimpleThread implements Runnable {

    SimpleThread(){

    }

    //x is shared between thread as its a global .But now its threadLocal so, it become unshared has init via initialValue.

     private static ThreadLocal<Integer> x=new ThreadLocal(){
         @Override
         protected Integer initialValue() {
             return 0;
         }
     };


    @Override
    public void run() {
        int xLocal = x.get();
        while (true){
            xLocal++;
            System.out.println(Thread.currentThread().getName()+" >> "+xLocal);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
