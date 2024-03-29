//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt(); // Inputting the testcases
        PrintWriter out = new PrintWriter(System.out);
        while (t-- > 0) {

            int i = 0;
            int N = sc.nextInt();

            int arr[] = new int[(int)(N)];

            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Solution ob = new Solution();
            out.println(ob.countSpecialNumbers(N, arr));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        // Code here
        HashMap<Integer,Integer> m=new HashMap<>();
       for(int i:arr){
           m.put(i,m.getOrDefault(i,0)+1);
       }
       int ans=0;
       for(int i=0;i<arr.length;i++){
           if((m.containsKey(arr[i]) && m.get(arr[i])>1) || isPossible(m,arr[i])){
               ans++;
           }
       }
       return ans;
    }
    private boolean isPossible(HashMap<Integer,Integer> m,int num){
        for(int i=1;i<=num;i++){
            if(num%i==0 && m.containsKey(i) && num!=i) return true;
        }
        return false;
   }
}