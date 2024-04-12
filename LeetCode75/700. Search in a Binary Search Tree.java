class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(true){
            if(root==null)
                return null;
            else if(root.val==val)
                return root;
            else if(root.val<val)
                root=root.right;
            else if(root.val>val)
                root=root.left;
        }
    }
}