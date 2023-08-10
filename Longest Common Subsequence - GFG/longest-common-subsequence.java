//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends






class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int m, int n, String s1, String s2)
    {
        // your code here
      int dp[][]=new int[m+1][n+1];
      for(int i=1;i<=m;i++)
      {
          for(int j=1;j<=n;j++)
          {
              dp[i][j]=-1;
          }
      }
        
        
    
    
    return lcsutil(m,n,s1,s2,dp);
}
    static int lcsutil(int m,int n,String s1,String s2,int dp[][])
    {
        if(m==0 || n==0)
        return 0;
        if(dp[m][n]!=-1)
        return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))
        return dp[m][n]=1+lcsutil(m-1,n-1,s1,s2,dp);
        else
        return dp[m][n]=Math.max(lcsutil(m-1,n,s1,s2,dp),lcsutil(m,n-1,s1,s2,dp));
    }
}