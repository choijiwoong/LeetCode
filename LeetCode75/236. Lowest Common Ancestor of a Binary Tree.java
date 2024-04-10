/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode p, q, LCA;
    private int hit_count;
    private void DFS(TreeNode node){
        if(node==null || hit_count==2)
            return;
        if(node==p || node==q)
            hit_count++;
        if(node.left!=null)
            DFS(node.left);
        if(node.right!=null)
            DFS(node.right);
    }

    private void BFS(TreeNode node){
        Queue<TreeNode> queue=new LinkedList();
        TreeNode iter;
        if(node==null)
            return;
        queue.add(node);
        while(!queue.isEmpty()){
            iter=queue.remove();

            hit_count=0;
            DFS(iter);
            if(hit_count==2)
                LCA=iter;

            if(iter.left!=null)
                queue.add(iter.left);
            if(iter.right!=null)
                queue.add(iter.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p=p;
        this.q=q;
        BFS(root);
        return LCA;
    }
}