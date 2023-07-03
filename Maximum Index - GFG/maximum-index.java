//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends




class Solution {

   int maxIndexDiff(int[] arr, int n) {
        int[] maxRight = new int[n]; // maxRight[i] stores the maximum element on the right of arr[i]
        maxRight[n - 1] = arr[n - 1]; // Initialize the maximum element on the right as the last element
        
        // Fill the maxRight array by iterating from right to left
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], arr[i]);
        }
        
        int maxDiff = 0; // Initialize the maximum difference
        
        // Find the maximum difference by iterating from left to right
        for (int i = 0, j = 0; i < n && j < n; ) {
            if (arr[i] <= maxRight[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++; // Move the right pointer forward
            } else {
                i++; // Move the left pointer forward
            }
        }
        
        return maxDiff;
    }
}