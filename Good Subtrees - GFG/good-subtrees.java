//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
	            int k=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Solution ob=new Solution();
                int ans=ob.goodSubtrees(root,k);
                out.println(ans);
                    t--;
            
            }
            out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int ans=0;
    static Map<Integer,Integer> help(Node root,int k){
        Map<Integer,Integer> mm = new HashMap<>();
        Map<Integer,Integer> mm2 = new HashMap<>();
        Map<Integer,Integer> mm3 = new HashMap<>();
        if(root.left!=null)
        mm2=help(root.left,k);
        if(root.right!=null)
        mm3=help(root.right,k);
        for(Map.Entry<Integer,Integer> x:mm2.entrySet()){
            mm.putIfAbsent(x.getKey(),0);
            mm.put(x.getKey(),mm.get(x.getKey())+x.getValue());
        }
        for(Map.Entry<Integer,Integer> x:mm3.entrySet()){
            mm.putIfAbsent(x.getKey(),0);
            mm.put(x.getKey(),mm.get(x.getKey())+x.getValue());
        }
        mm.putIfAbsent(root.data,0);
        mm.put(root.data,mm.get(root.data)+1);
        if(mm.size()<=k)ans++;
        return mm;
    }
    public static int goodSubtrees(Node root,int k)
    {
        ans=0;
        help(root,k);
        return ans;
    }
}