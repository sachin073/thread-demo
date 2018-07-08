package com.company.countDownLatch;

/**
 * Created by sachin on 8/7/18.
 */
public class Downloader implements Runnable {


    DownLoadMgr mgr;

    Downloader(DownLoadMgr downLoadMgr){
        mgr =downLoadMgr;
    }


    @Override
    public void run() {

        // wait for downloadMgr to start downloading.
        try {
            System.out.println(Thread.currentThread().getName()+" waiting for start command  ");

            mgr.startDownLoad.await();

            System.out.println(Thread.currentThread().getName()+" started downloading  ");
            Thread.sleep((int)Math.random()*1000);
            System.out.println(Thread.currentThread().getName()+" finished downloading and notified downloadMgr ");

            // tell downloadMgr download finished
            mgr.splitDownloader.countDown();

            // can still work on side business
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" downloader died!! ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
