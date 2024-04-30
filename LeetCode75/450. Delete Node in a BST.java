class Solution {
    private void delete_leaf_node(TreeNode root, int val, TreeNode prev){
        if(root.val<val)
            delete_leaf_node(root.right, val, root);
        else if(root.val>val)
            delete_leaf_node(root.left, val, root);
        else{
            if(prev.left.val==val)
                prev.left=null;
            else
                prev.right=null;
        }
    }

    private int remove(TreeNode node, int key, TreeNode prev){//삭제를 위한 본격적 함수
        if(node==null)//찾는 값이 없음
            return -1;

        if(node.val>key){//삭제할 값을 찾아가는 과정
            remove(node.left, key, node);
        } else if(node.val<key){
            remove(node.right, key, node);
        } else if(node.val==key){//삭제할 값을 찾았다!
            if(node.left==null && node.right==null){//1. 삭제할 노드의 자식이 없는 경우
                if(prev.left==node)
                    prev.left=null;
                else
                    prev.right=null;
            } else if(node.left==null && node.right!=null){//2. 삭제할 노드의 자식이 1개인 경우
                if(prev.left==node)
                    prev.left=node.right;
                else
                    prev.right=node.right;
            } else if(node.left!=null && node.right==null){//3. 동일
                if(prev.left==node)
                    prev.left=node.left;
                else
                    prev.right=node.left;
            } else {//4. 삭제할 노드의 자식이 2개인 경우
                TreeNode tmp=left(node.right);

            }

            if(prev==null){//루트 삭제_prev노드에 대한 재연결이 필요없다.
                
            } else {//일반삭제_prev노드에 대한 재연결이 필요하다.->prev노드 재연결을 따로 함수로 분리하여, 공통적인 작업으로 처리한다.

            }
        }
        return 0;
    }

    private TreeNode left(TreeNode node){
        if(node.left==null)
            return node;
        return left(node.left);
    }

    private TreeNode right(TreeNode node){
        if(node.right==null)
            return node;
        return right(node.right);
    }

    public TreeNode deleteNode(TreeNode root, int key){
        remove(root, key, null);

        return root;
    }
}