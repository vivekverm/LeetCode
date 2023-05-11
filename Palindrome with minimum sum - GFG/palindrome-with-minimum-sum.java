//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        // code here
    int n=s.length();
        int left=0;int right=n-1;
        //checking for validity
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)&&s.charAt(left)!='?'&&s.charAt(right)!='?')
                return -1;
                left++;
                right--;
        }
        left=0;right=n-1;
        StringBuffer str=new StringBuffer();
        //forming left half of new string while skipping indexes where both chars at
        //left and right index are '?' as they won't make a difference in the final output 
        while(left<=right){
            if(s.charAt(left)!='?')str.append(s.charAt(left));
            else if(s.charAt(right)!='?')str.append(s.charAt(right));
            left++;
            right--;
        }
        int res=0;
        for(int i=1;i<str.length();i++){
            res+=Math.abs(str.charAt(i)-str.charAt(i-1));
        }
        return res*2;
    }
}