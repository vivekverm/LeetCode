//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int isPossible(int n, int m, String s){
        int dx,dy;
        dx = dy = 0;
        int minx,maxx,miny,maxy;
        minx = maxx = miny = maxy = 0;
        for(char c:s.toCharArray()){
            if(c=='L') --dy;
            else if(c=='R') ++dy;
            else if(c=='D') --dx;
            else ++dx;
        
        minx = Math.min(minx,dx);
        maxx = Math.max(maxx,dx);
        miny = Math.min(miny,dy);
        maxy = Math.max(maxy,dy);
        if(maxx-minx>=n || maxy-miny >=m) return 0;
        }
        return 1;
    }
}