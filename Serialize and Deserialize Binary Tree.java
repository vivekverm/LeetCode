/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
       if(root==null)
           return "X";
       String leftserialize = serialize(root.left);
       String rightserialize = serialize(root.right);
       return root.val+","+ leftserialize + "," + rightserialize;    
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        Queue<String> nodeleft=new LinkedList<>();
        nodeleft.addAll(Arrays.asList(data.split(",")));
        return deserializehelper(nodeleft);
    }
    public TreeNode deserializehelper(Queue<String> nodeleft)
    {
        String valuefornode=nodeleft.poll();
        if(valuefornode.equals("X"))
            return null;
        TreeNode newNode=new TreeNode(Integer.valueOf(valuefornode));
        newNode.left=deserializehelper(nodeleft);
         newNode.right=deserializehelper(nodeleft);
        return newNode;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
