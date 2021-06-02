package demo10BinaryTree;

public class BinaryTree {
    public HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int id) {
        if (this.root != null) {
            if (this.root.id == id) { //root就是要删的，直接置为null
                this.root = null;
            } else {
                this.root.delNode(id);
            }
        } else {
            System.out.println("二叉树为空，不能删除");
        }
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int id) {
        if (this.root != null) {
            return this.root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int id) {
        if (this.root != null) {
            return this.root.infixOrderSearch(id);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int id) {
        if (this.root != null) {
            return this.root.postOrderSearch(id);
        } else {
            return null;
        }
    }
}
