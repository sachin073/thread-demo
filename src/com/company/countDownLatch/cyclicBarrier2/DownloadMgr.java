package com.company.countDownLatch.cyclicBarrier2;

/**
 * Created by sachin on 7/8/18.
 */
public class DownloadMgr implements Runnable{

    @Override
    public void run() {


        System.out.println("Mgr started ");


        System.out.println("clean up for few time");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Mgr ended");

    }
}
