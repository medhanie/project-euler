package com.github.medhanie.projecteuler.problem02;

/**
 * A palindromic number reads the same both ways. The smallest 6 digit palindrome made from the product of two 3-digit numbers is 101101=143×707101101=143×707.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers which is less than NN.
 * <p>
 * Input Format
 * First line contains TT that denotes the number of test cases. This is followed by TT lines, each containing an integer, NN.
 * <p>
 * Output Format
 * Print the required answer for each test case in a new line.
 * <p>
 * Constraints
 * 1≤T≤1001≤T≤100
 * 101101<N<1000000
 */

import java.util.*;

public class Problem02 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();

        List<Long> testCasesList = new ArrayList<>();
        for (int i = 0; i < numTestCases; i++) {
            long num = in.nextLong();
            testCasesList.add(num);
        }

        for (long inputNumber : testCasesList) {
            List<Integer> palins = new ArrayList<>();

            for(int index = 100000; index <= inputNumber; index++){
                if(checkPalindrom(index)){
                    palins.add(index);
                }
            }

            int maxPalin = 0;
            int divisor = 0;
            for(int i = 999; i >= 100; i--){
                for(int j = palins.size() - 1; j >=  0; j--){
                    int secondDivisor = palins.get(j)/i;
                    int remainder = palins.get(j)%i;
                    if(secondDivisor < 1000 && secondDivisor > 99 && remainder == 0){
                        if(palins.get(j) > maxPalin){
                            maxPalin = palins.get(j);
                            divisor = i;
                        }
                    }
                }
            }
            if(maxPalin != 0 && divisor != 0){
                System.out.println("Max Palin: " + maxPalin + ", divsiors: " + divisor + " X " + maxPalin/divisor);
            }
        }
    }

    private static boolean checkPalindrom(int num){
        String numStr = Integer.toString(num);

        int index = 0;
        int lastIndex = numStr.length() -1;

        while(index < lastIndex){
            if(numStr.charAt(index++) != numStr.charAt(lastIndex--)){
                return false;
            }
        }
        return true;
    }
}
