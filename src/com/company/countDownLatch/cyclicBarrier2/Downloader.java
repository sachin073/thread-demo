package com.company.countDownLatch.cyclicBarrier2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sachin on 7/8/18.
 */
public class Downloader implements Runnable{

    CyclicBarrier barrier;

    AtomicInteger counter ;

    public Downloader(CyclicBarrier barrier,AtomicInteger counter) {
        this.barrier = barrier;
        this.counter= counter;
    }

    @Override
    public void run() {

        System.out.println("download Thread started "+Thread.currentThread().getName());

        for (; counter.get() < 15;) {
            try {
                synchronized (this) { // downloading a part is one-go process for clean output .removing won't cause concurrency issue.

                if (counter.get() >= 15){ //busy condition check.
                    break;                // increment is done when value is less so need double check. lock is
                }

                    System.out.println(Thread.currentThread().getName() + " part downloading  " + counter.get());
                    Thread.sleep(1000);

                    System.out.println(Thread.currentThread().getName() + " part downloaded  " + counter.get());
                    counter.incrementAndGet();
                }

                barrier.await();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        System.out.println("download Thread ended "+Thread.currentThread().getName());

    }
}
