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
    private void DFS(TreeNode root, List list){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        if(root.left!=null)
            DFS(root.left, list);
        if(root.right!=null)
            DFS(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1=new ArrayList(), seq2=new ArrayList();
        DFS(root1, seq1);
        DFS(root2, seq2);

        if(seq1.size()!=seq2.size())
            return false;

        if(seq1.equals(seq2))
            return true;
        return false;
    }
}