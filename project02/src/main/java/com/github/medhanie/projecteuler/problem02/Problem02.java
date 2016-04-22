package com.github.medhanie.projecteuler.problem02;

/**
 *  Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 *                  1,2,3,5,8,13,21,34,55,89,⋯
 *                   
 *  By considering the terms in the Fibonacci sequence whose values do not exceed N, find the sum of the even-valued terms.
 *
 *  Input Format
 *  First line contains TT that denotes the number of test cases. This is followed by TT lines, each containing an integer, NN.
 *
 *  Output Format
 *  Print the required answer for each test case.
 *
 *  Constraints
 *      1≤T≤1051≤T≤105
 *      10≤N≤4×1016
 *
 *
 * SOLUTION: using Java8
 *
 *
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Problem02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();

        List<BigInteger> testCasesList = new ArrayList<>();
        for (int i = 0; i < numTestCases; i++) {
            BigInteger num = in.nextBigInteger();
            testCasesList.add(num);
        }

        for (BigInteger test : testCasesList) {
            List<BigInteger> fibList = new ArrayList<>();
            fibList.add(BigInteger.valueOf(1L));
            fibList.add(BigInteger.valueOf(2L));

            BigInteger lastFib = BigInteger.ZERO;
            while (true) {
                int index = fibList.size() - 1;
                lastFib = fibList.get(index).add(fibList.get(index - 1));
                if (lastFib.compareTo(test) <= 0) {
                    fibList.add(lastFib);
                } else {
                    break;
                }
            }
            List<BigInteger> filteredList = fibList.stream()
                    .filter(it -> it.mod(BigInteger.valueOf(2L)).compareTo(BigInteger.ZERO) == 0)
                    .collect(Collectors.toList());
            BigInteger sum = BigInteger.ZERO;
            for (BigInteger bigInt : filteredList) {
                sum = sum.add(bigInt);
            }
            System.out.println(sum);
        }
    }
}