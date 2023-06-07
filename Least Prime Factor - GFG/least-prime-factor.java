//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.leastPrimeFactor(n);
            for(int i = 1; i <=n; i++)
            {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public List<Integer> primes(int n){
        boolean[] prime = new boolean[n+1];
        for(int i=2;i*i<=n;i++){
            if(!prime[i]){
                int j = i*i;
                while(j<=n){
                    prime[j]=true;
                    j+=i;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(!prime[i])result.add(i);
        }
        return result;
    }
    public int[] leastPrimeFactor(int n)
    {
        // code here
        int [] result = new int[n+1];
        result[1] = 1;
        List<Integer> primes = primes(n);
        for(int prime : primes){
            int i=prime;
            while(i<=n){
                result[i] = result[i]!=0?Math.min(prime,result[i]):prime;
                i+=prime;
            }
        }
        return result;
    }
}