package com.company.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by sachin on 8/7/18.
 */
public class DownLoadMgr {

    CountDownLatch startDownLoad = new CountDownLatch(1);

    CountDownLatch splitDownloader = null;

    DownLoadMgr(int split){
        splitDownloader = new CountDownLatch(split);
    }

    public static void main(String[] args) {


        //download divided into 3 sub downloader
        final int DOWNLOAD_PARTS =3;
        DownLoadMgr downLoadMgr =new DownLoadMgr(DOWNLOAD_PARTS);

        for (int i = 0; i < DOWNLOAD_PARTS ; i++) {
                new Thread(new Downloader(downLoadMgr)).start();  //start 3 threads
        }

        // thread start downloading
        downLoadMgr.startDownLoad.countDown();
        System.out.println(" Command thread to start downloading now! " +
                "and downloadMgr waiting for download to finish");

        try {
            downLoadMgr.splitDownloader.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Assembling download ");


    }

}
