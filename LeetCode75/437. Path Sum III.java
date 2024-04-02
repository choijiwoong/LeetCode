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
    private int hit_count=0;
    private int target_sum;

    private void DFS(TreeNode node, int current_sum){
        if(node==null){
            return;
        }
        
        current_sum+=node.val;
        if(current_sum==target_sum)
            this.hit_count++;
        DFS(node.left, current_sum);
        DFS(node.right, current_sum);
        if(current_sum!=0){
            DFS(node.left, 0);
            DFS(node.right, 0);
        }
        
    }

    public int pathSum(TreeNode root, int targetSum) {
        this.target_sum=targetSum;
        this.DFS(root, 0);
        return this.hit_count;
    }
}