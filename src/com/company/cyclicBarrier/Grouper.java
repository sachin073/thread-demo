package com.company.cyclicBarrier;

/**
 * Created by sachin on 7/7/18.
 */
public class Grouper implements Runnable {

    private Result result;

    Grouper(Result result){
        this.result = result;
    }

    @Override
    public void run() {

        int finalResult=0;
        System.out.printf("Grouper: Processing results...\n");

        int data[]=result.getData();
        for (int number:data){
            finalResult+=number;
        }
        System.out.printf("Grouper: Total result: %d.\n",finalResult);



    }
}
