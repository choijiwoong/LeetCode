/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max_zigzag_length=0;
    private int tree_depth;

    private void zigzag_length_left(TreeNode node, int length){
        if(node.right!=null){
            zigzag_length_right(node.right, length+1);
        }
        if(max_zigzag_length<length)
            max_zigzag_length=length;
    }
    private void zigzag_length_right(TreeNode node, int length){
        if(node.left!=null){
            zigzag_length_left(node.left, length+1);
        }
        if(max_zigzag_length<length)
            max_zigzag_length=length;
    }

    private void DFS(TreeNode node){
        if (node==null)
            return;
        if(max_zigzag_length>=tree_depth-2)
            return;
    
        if(node.left!=null){
            zigzag_length_left(node.left, 1);
            DFS(node.left);
        }
        
        if(node.right!=null){
            zigzag_length_right(node.right, 1);
            DFS(node.right);
        }
    }

    public int find_depth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(1+find_depth(root.left), 1+find_depth(root.right));
    }

    public int longestZigZag(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return 0;
        tree_depth=find_depth(root);
        DFS(root);
        return max_zigzag_length;
    }
}