package demo14BinarySortTree;

public class BinarySortTree {
    private Node root;

    //找到值为value的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //找到value的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void infixOrder() {
        if (root == null) {
            System.out.println("BST为空！！");
        } else {
            root.infixOrder();
        }
    }

    //删除节点
    public void delNode(int value) {
        //空树就直接return掉
        if (root == null) {
            return;
        }
        //总之先找到当前节点
        Node targetNode = search(value);
        if (targetNode == null) {
            return; //没有找到要删除的节点，就直接return
        }
        //如果当前BST只有一个根节点，并且要删的就是根节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        //获取待删节点的父节点
        Node parent = searchParent(value);
        //3种情况，叶子节点，1颗子树，2颗子树
        if (targetNode.left == null && targetNode.right == null) {
            //叶子节点，直接让父节点指向null
            if (parent.left != null && parent.left.value == value) {
                parent.left = null;
            } else if (parent.right != null && parent.right.value == value) {
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right != null) {
            //2颗子树，找到右子树中的最小节点
            targetNode.value = delRightTreeMin(targetNode.right);
        } else {
            //1颗子树
            //先判断待删除节点具有左子树还是右子树
            if (targetNode.left != null) {
                //判断target是parent的左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = targetNode.left;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = targetNode.left;
                }
            } else { //具有右子树
                if (parent.left != null && parent.left.value == value) {
                    parent.left = targetNode.right;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = targetNode.right;
                }
            }
        }
    }

    //删除传入的子树的最小节点
    private int delRightTreeMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        //出循环时，找到了最左边的节点，将其删掉
        int value = node.value;
        delNode(node.value);
        return value;
    }
}
