package com.danielstone.alevels;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {

    public static void main(String[] args) {

        BufferedWriter outputFile = null;
        try {
            outputFile = new BufferedWriter(new FileWriter("result.csv", false));

            long[][] iterative = new long[35][3];
            long[][] recursive = new long[35][3];
            for (int i = 0; i < iterative.length; i++) {
                long start = System.nanoTime();
                long result = fibonacci(i + 1);
                long time = System.nanoTime() - start;
                iterative[i][0] = i + 1;
                iterative[i][1] = result;
                iterative[i][2] = time;
            }
            for (int i = 0; i < recursive.length; i++) {
                long start = System.nanoTime();
                long result = fibonacciRecursive(i + 2);
                long time = System.nanoTime() - start;
                recursive[i][0] = i + 1;
                recursive[i][1] = result;
                recursive[i][2] = time;
            }

            outputFile.write("Iteration,Result,Speed (nanoseconds)" + System.getProperty("line.separator"));
            for (int i = 0; i < iterative.length; i++) {
                outputFile.write(iterative[i][0] + "," + iterative[i][1] + "," + iterative[i][2] + System.getProperty("line.separator"));
            }
            outputFile.write(System.getProperty("line.separator"));
            for (int i = 0; i < recursive.length; i++) {
                outputFile.write(recursive[i][0] + "," + recursive[i][1] + "," + recursive[i][2] + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputFile != null) {
                try {
                    outputFile.flush();
                    outputFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private static long fibonacci(long n) {
        long num1 = 0, num2 = 1, result = 0;


        for (int i = 0; i < n; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }

        return result;
    }

    private static long fibonacciRecursive(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fibonacciRecursive(n-1) + fibonacciRecursive(n-2));
        }
    }
}
