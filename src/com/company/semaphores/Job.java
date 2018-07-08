package com.company.semaphores;

/**
 * Created by sachin on 5/7/18.
 */
public class Job implements Runnable {

    PrintQueue queue;
    Job(PrintQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {

        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        queue.printJob(new Object());

        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());

    }


    public static void main(String[] args) {

        PrintQueue printQueue=new PrintQueue();
         Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread"+i);
        }

        for (int i=0; i<10; i++){
            thread[i].start();
        }

    }
}
