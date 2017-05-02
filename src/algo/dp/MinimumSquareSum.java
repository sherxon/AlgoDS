package algo.dp;

/*
 Created by prafful1 on 5/2/2017
 Problem Statement: Minimum number of squares whose sum equals to given number n
 The below solution contains both Brute force recursive solution with exponential complexity and DP solution with improved polynomial complexity.
*/

public class MinimumSquareSum{
	
	/*
	 DP solution for Minimum Square Sum problem. Time Complexity O(n^2) and Space Complexity O(n).
	*/	
	static int sumDPSol(int n)
		{
			// Create a dynamic programming table
			//to prevent from calculating overlapping subproblems.
			int dp[] = new int[n+1];
      
			// getMinimumSquareSum table for base case entries
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 3;
      
			for (int i = 4; i <= n; i++)
			{
				// max value is i as i can always be represented
				// as 1*1 + 1*1 + ...
				dp[i] = i;
      
				// Finding minimum square sum and 
				//and storing in dp[] array.
				for (int x = 1; x <= i; x++) {
					int temp = x*x;
					if (temp > i)
						break;
					else dp[i] = Math.min(dp[i], 1+dp[i-temp]);
            }
        }
      
			// Return the final index value
			// from dp array.
			return dp[n];
		}		

	
	/*
	 BruteForce solution for Minimum Square Sum problem. The time complexity of this solution is exponential.
	*/
	static int sumRecursiveSol(int val)
		{
			// base cases
			if (val<=3)
				return val;
		
			// max value is i as i can always be represented
			// as 1*1 + 1*1 + ...
			int res = val;
		
			// This solution calculates overlapping 
			// subproblems multiple times.
			for (int i=1;i<=val;i++)
				{
				int temp = i*i;
				if (temp > val)
					break;
				else
					{
					res = Math.min(res,1+sumRecursiveSol(val-temp));
					}
				}
			return res;
		}		
}
