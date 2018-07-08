package com.company.localThread;

import org.junit.Test;


/**
 * Created by sachin on 1/6/18.
 */
public class Worker {

    @Test
    public void testTwoThread(){


        SimpleThread runnable = new SimpleThread();
        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();

        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
