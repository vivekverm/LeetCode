//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


class Solution
{
    public static Node modifyTheList(Node head)
    {
       ArrayList<Integer> hs=new ArrayList<>();
       while(head!=null)
       {
           hs.add(head.data);
           head=head.next;
       }
       Node nn=new Node(-1);
       Node p=nn;
       int n=hs.size();
       int j=hs.size()-1;
       for(int i=0;i<n/2;i++)
       {
           int y=hs.get(i);
           int x=hs.get(j)-hs.get(i);
           
           hs.set(i,x);
           hs.set(j,y);
           j--;
           
       }
       for(Integer i:hs)
       {
           nn.next=new Node(i);
           nn=nn.next;
           
       }
       return p.next;
       
    }
}