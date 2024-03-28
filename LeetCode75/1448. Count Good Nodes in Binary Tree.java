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
    private int good_node_count=0;
    private void DFS(TreeNode node, int max){
        if(node==null)
            return;
            
        if(node.val>=max){
            max=node.val;
            this.good_node_count++;
        }

        if(node.left!=null)
            DFS(node.left, max);
        
        if(node.right!=null)
            DFS(node.right, max);
    }
    public int goodNodes(TreeNode root) {
        DFS(root, root.val);
        return this.good_node_count;
    }
}