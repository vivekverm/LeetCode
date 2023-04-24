//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


class Solution{
	int [] nearestSmallestTower(int [] arr){
	    Stack<Integer> s = new Stack<Integer>();
	    int[] res = new int[arr.length];
	    for(int i=arr.length-1; i >=0; i--) {
	        while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
	            s.pop();
	        }
	        if(s.isEmpty()) {
	            res[i] = -1;
	        } else {
	            res[i] = s.peek();
	        }
	        s.push(i);
	    }
	    
	    s.clear();
	    
	    for(int i=0; i<arr.length; i++) {
	        while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
	            s.pop();
	        }
	        if(!s.isEmpty()){
	            if(res[i] == -1) {
	                res[i] = s.peek();
	            } else {
	                int index = s.peek();
	                if((i-index) < (res[i] - i)){
	                    res[i] = index;
	                } else if((i-index) == (res[i] - i)) {
	                    if(arr[index] <= arr[res[i]]){
	                        res[i] = index;
	                    }
	                }
	            }
	        }
	        s.push(i);
	    }
	    return res;
	}
}