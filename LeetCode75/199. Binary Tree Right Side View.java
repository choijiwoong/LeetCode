class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList();
        
        while(root!=null){
            list.add(root.val);
            root=root.right;
        }

        return list;
    }
}