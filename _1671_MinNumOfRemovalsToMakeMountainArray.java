package leetcode;

import java.util.Arrays;

/**
 *
 * @Sir Darey
 * 
 *
 */

class _1671_MinNumOfRemovalsToMakeMountainArray {
    
    public int minimumMountainRemovals(int[] nums) {
        //Using the method of Longest Bitonic Subsequence
        //We can find the LBS for the given array(Excluding index-0 && n-1), then, subtract the value from n
        //Algorithm for LBS is given as this:
        
        int n = nums.length, maxLBS = 0;
        int [] LIS = new int [n],       //for Longest Increasing Subsequence
               LDS = new int [n];       //for Longest Decreasing Subsequence
        
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        
        //for Longest Increasing Subsequence
        for (int i=1; i<n; i++)
            for (int j=0; j<i; j++) 
                if (nums[i] > nums[j] && LIS[i] < LIS[j]+1)
                    LIS[i] = LIS[j]+1;
        
        //for Longest Decreasing Subsequence
        for (int i=n-2; i>=0; i--)
            for (int j=n-1; j>i; j--)
                if (nums[i] > nums[j] && LDS[i] < LDS[j]+1)
                    LDS[i] = LDS[j]+1;
        
        //for Longest Bitonic Subsequence {LBS}
        //LBS[i] = LIS[i] + LDS[i] - 1;
        
        for (int i=1; i<n-1; i++) //Excluding i=0 && i=n-1
            if(LIS[i] > 1 && LDS[i] > 1)
                maxLBS = Math.max(maxLBS, (LIS[i] + LDS[i] - 1));
        
        return n - maxLBS;
    }
}