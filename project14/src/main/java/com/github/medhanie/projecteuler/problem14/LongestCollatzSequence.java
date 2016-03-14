package com.github.medhanie.projecteuler.problem14;

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 *
 * SOLUTION: using dynamic programming
 * 
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class LongestCollatzSequence {
	final static long MAX_RANGE = 1000000;
	static long count = 0;
	static long index = 0;
	static long largestCount = 0;
	static long largestNumber = 0;

	@SuppressWarnings("serial")
	final static Map<Long, Long> mapSequence = new HashMap<Long, Long>() {
		{
			put(1L, 1L);
		}
	};

	public static void main(String[] args) {
		for (int i = 1; i <= MAX_RANGE; i++) {
			index = i;
			getCollatzSequence(i);
			count = 0;
		}
		System.out.println("Largest Count: " + largestCount + " of Number: " + largestNumber);
	}

	public static long getCollatzSequence(long number) {
		if (mapSequence.containsKey(number)) {
			return count + mapSequence.get(number);
		}

		number = number % 2 == 0 ? number / 2 : 3 * number + 1;
		++count;
		long newNum = getCollatzSequence(number);
		mapSequence.put(index, newNum);
		if (newNum > largestCount) {
			largestCount = newNum;
			largestNumber = index;
		}
		return newNum;
	}

}
