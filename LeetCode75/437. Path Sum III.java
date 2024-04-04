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
    private long target_sum;
    private Queue<TreeNode> queue=new LinkedList();

    private void DFS(TreeNode node, long current_sum){
        if(node==null)
            return;
        if(node.left!=null)
            queue.add(node.left);
        if(node.right!=null)
            queue.add(node.right);
        
        current_sum+=node.val;
        if(current_sum==this.target_sum)
            this.hit_count++;

        DFS(node.left, current_sum);
        DFS(node.right, current_sum);
    }
    private void DFS2(TreeNode node, long current_sum){
        if(node==null)
            return;

        current_sum+=node.val;
        if(current_sum==this.target_sum)
            this.hit_count++;
        
        DFS2(node.left, current_sum);
        DFS2(node.right, current_sum);
    }

    public int pathSum(TreeNode root, long targetSum) {
        this.target_sum=targetSum;
        this.DFS(root, 0);
        while(!queue.isEmpty()){
            this.DFS2(queue.remove(), 0);
        }

        return this.hit_count;
    }
}