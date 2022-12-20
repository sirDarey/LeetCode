package leetcode;

/**
 *
 * @Sir Darey
 **/
public class _1646_GetMaxInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int dp [] = new int [n+1];
        dp[1] = 1;
        dp[2] = 1;
        
        int max = 1;
        for (int i=3; i<=n; i++) {
            if ((i%2) == 0)
                dp[i] = dp[i/2];
            else
                dp[i] = dp[i/2] + dp[(i+1)/2];

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
