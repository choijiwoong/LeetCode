class Solution {
    private int[] accumulator=new int[10000];

    private int DFS(TreeNode node, int depth){
        if(node==null)
            return 0;
        accumulator[depth]+=node.val;
        return 1+ Math.max(DFS(node.left, depth+1), DFS(node.right, depth+1));
    }

    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        int depth=DFS(root, 0);
        int max_index=0;
        for(int i=1; i<depth; i++)
            if(accumulator[max_index]<accumulator[i])
                max_index=i;
        
        return max_index+1;
    }
}