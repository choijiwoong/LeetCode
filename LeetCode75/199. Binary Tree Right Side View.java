class Solution {
    private List<Integer> list=new ArrayList();
    private int diter=0;
    
    private void DFS(TreeNode node, int depth){
        if(node==null)
            return;
        if(depth==diter){
            diter++;
            list.add(node.val);
        }
        DFS(node.right, depth+1);
        DFS(node.left, depth+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return list;
        DFS(root, 0);
        return list;
    }
}