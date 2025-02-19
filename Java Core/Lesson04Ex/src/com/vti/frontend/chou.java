package com.vti.frontend;

import java.util.Scanner;

public class chou {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
        int N = in.nextInt();
                int[] X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = in.nextInt();
        }
        int sum = 0;
        for(int i = 0; i< N; i++){
            sum += X[i];
        }


        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(sum);
    }
}

