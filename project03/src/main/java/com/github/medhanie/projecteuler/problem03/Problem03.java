import java.math.BigInteger;
import java.util.*;

/**
 * Created by Medhanie on 4/22/2016.
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of a given number N?
 * <p>
 * Input Format
 * <p>
 * First line contains TT, the number of test cases. This is followed by TT lines each containing an integer NN.
 * <p>
 * Output Format
 * For each test case, display the largest prime factor of NN.
 * <p>
 * Constraints
 * 1≤T≤101≤T≤10
 * 10≤N≤1012
 */
public class Problem03 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();

        List<Long> testCasesList = new ArrayList<>();
        for (int i = 0; i < numTestCases; i++) {
            long num = in.nextLong();
            testCasesList.add(num);
        }

        for (long inputNumber : testCasesList) {
            long maxfactor = 1L;

            if( inputNumber % 2 == 0){
                maxfactor = 2;
                inputNumber /= 2;
                while(inputNumber % 2 == 0){
                    inputNumber /= 2;
                }
            } else{
                maxfactor = 1L;
            }

            long upperbound = (long) Math.sqrt(inputNumber);
            long testfactor = 3L;
            while(inputNumber > 1 && testfactor <= upperbound){
                if(inputNumber % testfactor == 0){
                    inputNumber /= testfactor;
                    maxfactor = testfactor;
                    while(inputNumber % testfactor == 0){
                        inputNumber /= testfactor;
                    }
                    upperbound = (long) Math.sqrt(inputNumber);
                }
                testfactor += 2;
            }
            System.out.println( inputNumber == 1 ? maxfactor : inputNumber);
        }
    }
}
