package demo15AVLTree;

public class Node {
    int value;
    Node left;
    Node right;

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

    public void addNode(Node node) {
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
        //添加完毕后，判断是否需要旋转
        if (leftHeight() - rightHeight() > 1) { //左子树太高，右旋转
            if (left != null && (left.rightHeight() > left.leftHeight())) { //左子树的右子树太高，左旋转调整一下
                left.leftRotate();
            }
            rightRotate();
        } else if (rightHeight() - leftHeight() > 1) { //右子树太高，左旋转
            if (right != null && (right.leftHeight() > right.rightHeight())) { //右子树的左子树太高，右旋转调整一下
                right.rightRotate();
            }
            leftRotate();
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

    //返回当前Node节点为根节点的树的高度
    public int height() {
        return Math.max(left != null ? left.height() : 0, right != null ? right.height() : 0) + 1;
    }

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //右旋转
    public void rightRotate() {
        //先复制当前节点
        Node newNode = new Node(value);
        //新节点的左节点指向根左右
        newNode.left = left.right;
        //新节点的右节点指向根右
        newNode.right = right;
        //替换根节点的值为左节点
        value = left.value;
        left = left.left;
        right = newNode;
    }

    //左旋转
    public void leftRotate() {
        Node newNode = new Node(value);
        newNode.left = left;
        newNode.right = right.left;
        value = right.value;
        left = newNode;
        right = right.right;
    }
}
