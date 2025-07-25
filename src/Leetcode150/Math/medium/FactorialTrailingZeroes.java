package Leetcode150.Math.medium;

import java.math.BigInteger;

/*
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.



Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0


Constraints:

0 <= n <= 104


Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class FactorialTrailingZeroes {
    public static int trailingZeroesInefficient(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        int count = 0;
        while (fact.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            count++;
            fact = fact.divide(BigInteger.TEN);
        }
        return count;
    }

    public static int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(0));
    }

}
