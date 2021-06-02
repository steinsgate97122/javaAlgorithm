package demo10BinaryTree;

public class HeroNode {
    public int id;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
        //左右节点默认为空
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //删除节点，如果节点不是叶子节点，也连带着子树一起删除
    public void delNode(int id) {
        //判断当前节点的左子节点是不是要删除的节点，如果有的话
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return; //删除之后直接返回
        }
        //右子节点一样
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return; //删除之后直接返回
        }
        //如果都没有删除，那么对左子节点递归
        if (this.left != null) {
            this.left.delNode(id);
        }
        //还没有删除，对右子节点递归
        if (this.right != null) {
            this.right.delNode(id);
        }
    }

    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode preOrderSearch(int id) {
        System.out.println("前序查找"); //统计一下查找次数
        //先判断当前节点
        if (this.id == id) {
            return this;
        }
        HeroNode tempNode = null;
        // 判断左子节点，递归
        if (this.left != null) {
            tempNode = this.left.preOrderSearch(id);
        }
        //如果tempNode找到了就返回
        if (tempNode != null) {
            return tempNode;
        }
        // 判断右子节点，递归
        if (this.right != null) {
            tempNode = this.right.preOrderSearch(id);
        }
        return tempNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int id) {
        HeroNode tempNode = null;
        // 判断左子节点，递归
        if (this.left != null) {
            tempNode = this.left.infixOrderSearch(id);
        }
        //如果tempNode找到了就返回
        if (tempNode != null) {
            return tempNode;
        }
        System.out.println("中序查找"); //统计一下查找次数
        //判断当前节点
        if (this.id == id) {
            return this;
        }
        // 判断右子节点，递归
        if (this.right != null) {
            tempNode = this.right.infixOrderSearch(id);
        }
        return tempNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int id) {
        HeroNode tempNode = null;
        // 判断左子节点，递归
        if (this.left != null) {
            tempNode = this.left.postOrderSearch(id);
        }
        //如果左子节点找到了就返回
        if (tempNode != null) {
            return tempNode;
        }
        // 判断右子节点，递归
        if (this.right != null) {
            tempNode = this.right.postOrderSearch(id);
        }
        //如果右子节点找到了就返回
        if (tempNode != null) {
            return tempNode;
        }
        System.out.println("后序查找"); //统计一下查找次数
        //判断当前节点
        if (this.id == id) {
            return this;
        }
        return tempNode;
    }
}
