package com.company.countDownLatch.cyclicBarrier2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sachin on 7/8/18.
 */
public class Client {


    public static void main(String[] args) {

        int Parts=6;

        CyclicBarrier barrier = new CyclicBarrier(Parts,new DownloadMgr());

        Downloader downloader = new Downloader(barrier,new AtomicInteger(0));

        new Thread(downloader).start();
        new Thread(downloader).start();
        new Thread(downloader).start();
        new Thread(downloader).start();
        new Thread(downloader).start();
        new Thread(downloader).start();

    }

}
