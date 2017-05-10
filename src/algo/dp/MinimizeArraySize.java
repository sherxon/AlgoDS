/*
Problem Statement: Find minimum possible size of array with given rules for removing elements

Description: Given an array of numbers and a constant k, minimize size of array with following rules for removing elements.
Exactly three elements can be removed at one go.
The removed three elements must be adjacent in array, i.e., arr[i], arr[i+1], arr[i+2]. And the second element must be k greater than first and third element must be k greater than second, i.e., arr[i+1] – arr[i] = k and arr[i+2]-arr[i+1] = k.

Testcses that both solutions were tested against:
Input: arr[] = {100, 101, 105, 2, 10, 12, 14, 4, 22, 24, 26, 6, 500}, k = 2
Output: 4
First we can remove: {10,12,14} and {22,24,26}
Second we can remove: {2,4,6}
Remaining that can't be removed: {100,101,105,500}

Input: arr[] = {2, 3, 4, 5, 6, 4}, k = 1
Output: 0
We can actually remove all elements. 
First remove 4, 5, 6 => We get {2, 3, 4}
Now remove 2, 3, 4   => We get empty array {}

Input:  arr[] = {2, 3, 4, 7, 6, 4}, k = 1
Output: 3
We can only remove 2 3 4

Input: arr[] = {1,2},k=1
Output: 2 
*/



package algo.dp;

public class MinimizeArraySize{
	
	/*
	Brute force solution
	low: first index of array arr[]
	high: last index of array arr[]
	arr[]: user input array
	k: constant
	*/
	public int noDPSol(int low, int high, int arr[], int k)
		{
		//base case
		if ((high-low+1)<3)
			return high-low+1;

		//Considering first element cannot be removed
		int res = 1 + noDPSol(low+1, high, arr, k);
		
		for (int i=low +1 ; i<=high-1;i++)
			for (int j = i+1; j<=high; j++)
				{
				// checking if all elements between "low" and "j" can be removed	
				if(((arr[i]-arr[low])==k) && ((arr[j]-arr[i])==k) && noDPSol(low+1,i-1,arr,k)==0 && noDPSol(i+1,j-1,arr,k)==0)
					{
					res = Math.min(res,noDPSol(j+1,high,arr,k));
					}
				}
		return res;
		}
		
	/*
	DP based solution
	low: first index of array arr[]
	high: last index of array arr[]
	arr[]: user input array
	k: constant
	dp[][]: lookup array prevents from recalculation
	of a subproblem. (should be initialized with -1 as all index values)
	*/
	public int dpSol(int low, int high, int arr[], int k,int dp[][])
		{
		
		//base case
		if ((high-low+1)<3)
			return high-low+1;
		
		//lookup array
		//returns already calculated
		// subproblem result.
		if(dp[low][high] !=-1)
			return dp[low][high];

		//Considering first element cannot be removed
		int res = 1 + dpSol(low+1, high, arr, k,dp);
		
		for (int i=low +1 ; i<=high-1;i++)
			for (int j = i+1; j<=high; j++)
				{
				if(((arr[i]-arr[low])==k) && ((arr[j]-arr[i])==k) && dpSol(low+1,i-1,arr,k,dp)==0 && dpSol(i+1,j-1,arr,k,dp)==0)
					{
					// checking if all elements between "low" and "j" can be removed
					res = Math.min(res,dpSol(j+1,high,arr,k,dp));
					}
				
				}
		return dp[low][high] = res;
		}
}
