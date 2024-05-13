class Solution {
    private TreeNode rt;

    private void replace_and_disconnect(TreeNode parent, TreeNode node){//삭제할 대상의 부모노드, 삭제할 대상노드. 대상노드를 대체할 최적값을 찾음
        TreeNode victim_1, victim;//삭제대상 노드와 swap될 대상노드의 부모노드
        if(parent.right==node){//swap 대상노드 탐색을 위한 방향설정
            if(node.right.left==null){
                victim_1=node;
                victim=node.right;
                parent.right=victim;
                victim.left=node.left;
            } else {
                if(node.right!=null){
                    System.out.println("check");
                    victim_1=left_1(node.right);//swap대상 노드의 부모노드
                    victim=victim_1.left;//swap대상 노드
                    victim_1.left=victim.right;//disconnection gdgdgd
                    node.val=victim.val;//swap
                } else {
                    victim_1=left_1(node);//swap대상 노드의 부모노드
                    victim=victim_1.left;//swap대상 노드
                    victim_1.left=null;//disconnection
                    node.val=victim.val;//swap
                }
            }
        } else {
            if(node.left.right==null){
                victim_1=node;
                victim=node.left;
                parent.left=victim;
                victim.right=node.right;
            } else {
                if(node.left!=null){
                    victim_1=right_1(node.left);
                    victim=victim_1.right;
                    victim_1.right=victim.left;//dgdg
                    node.val=victim.val;
                } else {
                    victim_1=right_1(node);
                    victim=victim_1.right;
                    victim_1.right=null;
                    node.val=victim.val;
                }
            }
        }
    }

    private TreeNode get_parent_node(TreeNode cur, TreeNode node){//탐색을 시작하고 싶은 노드, 탐색하고자하는 노드로 부모노드 탐색
        if(cur.left==node || cur.right==node)//현재 cur이 node의 부모노드일 때
            return cur;
        if(cur.val<node.val)//이진분류에 따른 재귀호출
            return get_parent_node(cur.right, node);
        else if(cur.val>node.val)
            return get_parent_node(cur.left, node);
        else{//탐색 실패
            System.out.println("루트로부터 노드탐색 실패");//루트가 대상일 때
            return null;
        }
    }

    private void branch_per_child_node(TreeNode node){//삭제대상의 노드를 찾았을 때, 해당 노드의 자식 개수에 따른 작업 분기처리
        TreeNode parent=get_parent_node(this.rt, node);//삭제 대상의 부모노드
        if(parent!=null){//삭제하고자하는 노드가 루트노드가 아니라면
            if(node.left==null && node.right==null){//삭제 대상 노드의 자식이 없을 경우
                if(parent.left==node)//부모와의 연결을 끊음
                        parent.left=null;
                else
                    parent.right=null;
            } else if(node.left==null && node.right!=null){//삭제 대상 노드의 자식이 1개일 경우
                if(parent.left==node)//부모와 삭제대상 자식노드와 연경
                    parent.left=node.right;
                else
                    parent.right=node.right;
            } else if(node.left!=null && node.right==null){//삭제 대상 노드의 자식이 1개일 경우
                if(parent.left==node)//부모와 삭제대상 자식노드와 연결
                    parent.left=node.left;
                else
                    parent.right=node.left;
            } else {//삭제 대상 노드의 자식이 2개일 경우
                replace_and_disconnect(parent, node);//대체값을 찾고 연결을 끊는 함수 호출
            }
        } else {
            //루트노드가 삭제 대상이어서 parent와의 disconnet가 필요하지 않다면
            if(node.right==null&& node.left!=null){
                this.rt=node.left;
                return;
            }
            if(node.right==null)
                return;
            TreeNode victim_1=left_1(node.right);
            TreeNode victim;
            if(victim_1==null){//루트노드 삭제
                victim_1=node;
                victim=node.right;
                this.rt=victim;
                this.rt.left=victim_1.left;
            } else{
                victim=victim_1.left;
                victim_1.left=null;
                node.val=victim.val;
            }
        }
    }

    private void remove(TreeNode node, int key){//삭제를 위한 본격적 함수_우선적으로 삭제할 노드의 값을 탐색한다.
        if(node==null)//찾는 값이 없음
            return;

        if(node.val<key){//현재 노드가 키값보다 작은 경우
            remove(node.right, key);
        } else if(node.val>key){//현재 노드가 키값보다 큰 경우
            remove(node.left, key);
        } else if(node.val==key){//삭제대상을 찾은 경우
            branch_per_child_node(node);//대상의 자식 노드 개수에 따른 분기를 처리
        } else {//값이 없는 경우
            //아무 일도 처리하지 않음
        }
    }
    
    private TreeNode left_1(TreeNode node){
        if(node.left==null)
            return null;
        if(node.left!=null && node.left.left==null)
            return node;
        return left_1(node.left);
    }

    private TreeNode right_1(TreeNode node){
        if(node.right==null)
            return null;
        if(node.right!=null && node.right.right==null)
            return node;
        return right_1(node.right);
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null)//루트가 비어있을 경우
            return null;
        if(root.left==null && root.right==null && root.val==key)//루트의 자식이 없고 루트가 삭제 대상일 경우
            return null;

        this.rt=root;//루트노드 멤버변수로 설정. 재귀형식으로 함수를 작성할거기에 다양한 접근이 필요.
        remove(root, key);//실질적인 삭제작업 수행

        return this.rt;
    }
}