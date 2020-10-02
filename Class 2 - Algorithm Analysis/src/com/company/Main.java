package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    /*
    Problem:
    Given (possibly negative) integers A1, A2, ... , AN, find the maximum value of sum(Ak).
    (For convenience, the maximum subsequence sum is 0 if all the integers are negative.)
    Ex.: −2, 11, −4, 13, −5, −2
     */

    public static void print(String s){
        System.out.println(s);
    }
    /// O(N^3) Solution (Exhaustive)
    public static int maxSubSum1(int [] a){
        int n = a.length;
        int maxSum = 0;
        for(int start = 0; start < n; start++){

            for(int end = start; end < n; end++){

                int currentSum = 0;
                for(int i = start; i < end; i++){
                    currentSum += a[i];
                }

                if(currentSum > maxSum){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    /// O(N^2) Solution (Exhaustive)
    public static int maxSubSum2(int [] a){
        int n = a.length;
        int maxSum = 0;
        for(int start = 0; start < n; start++){
            int currentSum = 0;
            for(int end = start; end < n; end++){

                currentSum += a[end];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    /// O(NlogN) Solution (Divide and conquer)
    public static int maxSubSumRec(int [] a, int left, int right){
        // Base case
        if(left == right)
            if(a[left] > 0)
                return a[left];
            else
                return 0;

        int center = (left + right) / 2;
        int maxLeftSum = maxSubSumRec(a, left, center);
        int maxRightSum = maxSubSumRec(a, center+ 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--)
        {
            leftBorderSum += a[i];
            if(leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++)
        {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }
        return Collections.max(Arrays.asList(new Integer[]{maxLeftSum,maxRightSum ,
                                             maxRightBorderSum + maxLeftBorderSum}));
    }

    /// O(N) Solution
    public static int maxSubSumBest(int [] a){
        int currentSum = 0, maxSum = 0;
        for(int i = 0; i < a.length; i++){
            currentSum += a[i];
            if(currentSum > maxSum)
                maxSum = currentSum;
            else if(currentSum < 0)
                currentSum = 0;

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] intArray = {-2, 11, -4, 13, -5, -2};
        print("O(N^3) solution: " + Integer.toString(maxSubSum1(intArray)));
        print("O(N^2) solution: " + Integer.toString(maxSubSum2(intArray)));
        print("O(N*logN) solution: " + Integer.toString(maxSubSumRec(intArray, 0, intArray.length - 1)));
        print("O(N) solution: " + Integer.toString(maxSubSumBest(intArray)));
    }
}
