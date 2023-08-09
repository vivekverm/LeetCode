//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static long largestPrimeFactor(int n) {
        long maxPrime = -1;
        while (n % 2 == 0) {
            maxPrime = 2;
            n = n / 2;
        }
        while (n % 3 == 0) {
            maxPrime = 3;
            n = n / 3;
        }
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                maxPrime = i + 2;
                n = n / (i + 2);
            }
        }
        if (n > 4)
            maxPrime = n;
        return maxPrime;
    }
}