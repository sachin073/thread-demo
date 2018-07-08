package com.company.semaphores;

import java.util.Locale;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sachin on 5/7/18.
 */
public class PrintQueue {


    private final Semaphore semaphore;
    private boolean freePrinters[];
    private Lock lockPrinters;

    PrintQueue(){
        semaphore= new Semaphore(3);
        freePrinters = new boolean[3];
        lockPrinters = new ReentrantLock();
        for (int i=0; i<3; i++){
            freePrinters[i]=true;
        }

    }



    public void printJob(Object o){


        try {
            semaphore.acquire();  // if its construct by 1 then only 1 thead run
                                    // if used 3 to construct then 3 can enter this section

            int assignedPrinter=getPrinter(); // point of race condition
                                              // race to acquire same printer by two thread. so used reentrant lock

            long duration=(long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job by %dduring %d seconds\n",Thread.currentThread().getName(),assignedPrinter,duration);
            Thread.sleep(duration);
            freePrinters[assignedPrinter]=true;

        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;

        try {
            lockPrinters.lock();
            for (int i=0;i<freePrinters.length;i++){
                if (freePrinters[i]){
                    ret=i;
                    freePrinters[i]=false;
                    break;
                }
            }
        } finally {
                lockPrinters.unlock();
        }


        return ret;
    }
}
