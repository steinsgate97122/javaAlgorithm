package demo14BinarySortTree;

public class Node {
    int value;
    demo14BinarySortTree.Node left;
    demo14BinarySortTree.Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //找到当前子树中值为value的节点
    public Node search(int value) {
        if (this.value == value) { //找到了
            return this;
        }
        if (value < this.value) { //往左子树递归查找
            if (this.left != null) {
                return this.left.search(value);
            }
        } else { //往右子树递归查找
            if (this.right != null) {
                return this.right.search(value);
            }
        }
        //递归完毕，还没找到
        return null;
    }

    //找到当前子树中value的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        }
        if (value < this.value) {
            if (this.left != null) {
                return this.left.searchParent(value);
            }
        } else { //value等于当前节点的值时，也往右子树找
            if (this.right != null) {
                return this.right.searchParent(value);
            }
        }
        return null;
    }

    public void addNode(demo14BinarySortTree.Node node) {
        if (node == null) {
            return;
        }
        //与子树的根节点比较大小
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                //递归
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }
    }

    //为了方便查看，写一个中序遍历
    public void infixOrder() {
        //左子树递归
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
