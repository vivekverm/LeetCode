//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


class Solution
{
    public Node constructBTree(int pre[], int preM[], int size)
    {
        return construct(pre, 0, size - 1);
    }
    
    public Node construct(int pre[], int l, int r)
    {
        int mid = (l+r)>>1;
        
        Node root = new Node(pre[l]);
        if(l < r)
        {
            root.left = construct(pre, l+1, mid);
            root.right = construct(pre, mid+1, r);
        }
        return root;
    }
    
}