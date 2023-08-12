//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int f(int i,int[] a,int prev,int[][] dp){
        if(i == a.length) return 0;
        if(prev>-1 && dp[i][prev] != -1) return dp[i][prev];
        int take = Integer.MIN_VALUE, nottake = Integer.MIN_VALUE;
        if(prev < 0){
            nottake = 0 + f(i+1,a,prev,dp);
            take = 1 + f(i+1,a,i,dp);
            return Math.max(take,nottake);
        }
        nottake = 0 + f(i+1,a,prev,dp);
        if(a[i] > a[prev]) take = 1 + f(i+1,a,i,dp);
        return dp[i][prev] = Math.max(take,nottake);
    }
    static int longestSubsequence(int size, int a[])
    {
       
        int[] tails = new int[size];
        int sz=0;
        for(int x:a){
            int i=0,j=sz;
            while(i<j){
                int m = (i+j)/2;
                if(tails[m]<x) i=m+1;
                else j=m;
            }
            tails[i] = x;
            if(i==sz) ++sz;
        }
        return sz;
    }
}  