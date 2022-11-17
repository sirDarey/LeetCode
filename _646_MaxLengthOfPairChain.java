package leetcode;

import java.util.Arrays;

/**
 *
 * @Sir Darey
 * 
 *
 */

class _646_MaxLengthOfPairChain {
    
    public int findLongestChain(int[][] pairs) {
       
        Arrays.sort(pairs, (a, b) -> a[0]-b[0]);
        int max = 0;
        
        int prev = Integer.MIN_VALUE;
        
        for(int[] pair : pairs){
            if(pair[0] > prev){ 
                max++;
                prev = pair[1];
            } else if(pair[1] < prev){ 
                prev = pair[1];
            }
        }
        return max;
    }
}