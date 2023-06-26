//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int nCr(int n, int r)
    {
        if(n<r){
            return 0;
        }else if(n==r || r==0){
            return 1;
        }else if(r==n-1 || r==1){
            return n;
        }else{
            int mod=1000000007;
            int[] arr=new int[r+1];
            int curr=0;
            arr[0]=1;
            for(int i=0;i<n;i++){
                int t=curr;
                boolean flag=true;
                if(curr<r){
                    curr+=1;
                }else{
                    flag = false;
                }
                if(flag){
                    arr[curr]=1;
                }
                while(t>0){
                    arr[t]=(arr[t]+arr[t-1])%mod;
                    --t;
                }
                //System.out.println(Arrays.toString(arr));
            }
            return arr[r];
        }
    }
}