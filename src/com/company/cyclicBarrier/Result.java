package com.company.cyclicBarrier;

/**
 * Created by sachin on 5/7/18.
 */
public class Result {
    private int data[];

    public Result(int size){
        data = new int[size];
    }


    public void setData(int position, int value){
        data[position]=value;
    }


    public int[] getData(){
        return data;
    }



}
