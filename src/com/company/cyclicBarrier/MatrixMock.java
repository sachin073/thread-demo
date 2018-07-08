package com.company.cyclicBarrier;

import java.util.Random;

/**
 * Created by sachin on 5/7/18.
 */
public class MatrixMock {

    private int data[][];

    MatrixMock(int row,int column,int number){
    int counter =0;
        data = new int[row][column];
        Random random = new Random(2);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                data[i][j]=random.nextInt() % 20;
                if (data[i][j]==number)
                        counter++;
            }
        }
        System.out.printf("Mock: There are %d ocurrences " +
                "of number in generated data.\n",counter,number);
    }


    public int[] getRow(int row){
        if ((row>=0)&&(row<data.length)){
            return data[row];
        }
        return null;
    }


}
