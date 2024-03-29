//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Pair {
    int nodeMin, nodeMax, nodeSum, countNode;
    boolean isBST;
} class Solution {
    static int min;
    public static int minSubtreeSumBST(int target, Node root) {
        min = Integer.MAX_VALUE;
        minSubtree(root, target);
        if (min == Integer.MAX_VALUE) min = -1;
        return min;
    }
    public static Pair minSubtree(Node root, int target) {
        if (root == null) {
            Pair p = new Pair();
            p.nodeMin = Integer.MAX_VALUE;
            p.nodeMax = Integer.MIN_VALUE;
            p.nodeSum = 0;
            p.countNode = 0;
            p.isBST = true;
            return p;
        }
        Pair left = minSubtree(root.left, target);
        Pair right = minSubtree(root.right, target);
        int nodeSum = left.nodeSum + right.nodeSum + root.data;
        int countNode = left.countNode + right.countNode + 1;
        int nodeMin = Math.min(root.data, Math.min(left.nodeMin, right.nodeMin));
        int nodeMax = Math.max(root.data, Math.max(left.nodeMax, right.nodeMax));
        boolean isBST = root.data > left.nodeMax && root.data < right.nodeMin && left.isBST && right.isBST;
        if (isBST && nodeSum == target) min = Math.min(min, countNode);
        Pair p = new Pair();
        p.nodeMin = nodeMin;
        p.nodeMax = nodeMax;
        p.nodeSum = nodeSum;
        p.countNode = countNode;
        p.isBST = isBST;
        return p;
    }
}
