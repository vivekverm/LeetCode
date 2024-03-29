//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    HashSet<Integer> set = new HashSet<>();
	    Node curr = head1;
	    Node curr1 = head2;
	    while(curr != null){
	        set.add(curr.data);
	        curr = curr.next;
	    }
	    while(curr1 != null){
	        set.add(curr1.data);
	        curr1 = curr1.next;
	    }
	    ArrayList<Integer> list = new ArrayList<>(set);
	    Collections.sort(list);
	    Node res = new Node(list.get(0));
        Node Curr = res;
        for(int i = 1; i < list.size(); i++){
            Node n = new Node(list.get(i));
            Curr.next = n;
            Curr = n;
        }
        return res;
	}
}