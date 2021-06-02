package demo10BinaryTree.threadedBinaryTree;

public class BinaryTree {
    public HeroNode root;
    private HeroNode pre;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //中序遍历线索化二叉树
    public void infixThreadedList(){
        HeroNode node = root; //node指向当前节点
        while (node != null){
            //中序遍历，先遍历左子树，找到该子树最左边的叶子节点
            while (node.leftType != 1){
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1){
                node = node.right;
                System.out.println(node);
            }
            // 出循环后，移动到右子树的根节点
            node = node.right;
        }
    }

    //前序遍历线索化二叉树
    public void preThreadedList(){
        HeroNode node = root; //node指向当前节点
        while (node.right != null){
            //前序遍历，先遍历根节点
            System.out.println(node);
            //遍历其后继节点
            while (node.rightType == 1){
                node = node.right;
                System.out.println(node);
            }
            // 出循环后，移动到左子树的根节点
            if(node.right != null){
                node = node.left;
            }
        }
    }

//    //后序遍历线索化二叉树，这个方法需要在节点中多定义一个父指针
//    public void postThreadedList(){
//        HeroNode node = root; //node指向当前节点
//        while (node != null){
//            //后序遍历，先遍历左子树
//            while (node.leftType != 1){
//                node = node.left;
//            }
//            System.out.println(node);
//            while (node.rightType == 1){
//                node = node.right;
//                System.out.println(node);
//            }
//            //右指针不再指向后继，移动到当前节点的父节点，这个时候要借助另外一个指针
//            node = node.parent; //父指针没定义，这里就不写了
//            if(node == root){
//                System.out.println(node);
//                break;
//            }
//        }
//    }

    //中序线索化二叉树，用递归写，先向左子节点递归，然后根，然后右
    public void infixThreaded(HeroNode node) {
        if (node == null) { //终止条件
            return;
        }
        infixThreaded(node.left);
        //如果左指针为空，就指向前驱节点
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        //如果前驱节点的右指针为空，就指向当前节点
        if (pre != null && pre.right == null) {
            pre.right = node; //pre这里不能是null
            pre.rightType = 1;
        }
        pre = node;
        infixThreaded(node.right);
    }

    //前序线索化二叉树
    public void preThreaded(HeroNode node) {
        if (node == null) { //终止条件
            return;
        }
        //如果左指针为空，就指向前驱节点
        HeroNode temp = node.left;  //向左递归的时候要用，不然null被覆盖掉了，会死循环
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        //如果前驱节点的右指针为空，就指向当前节点
        if (pre != null && pre.right == null) {
            pre.right = node; //pre这里不能是null
            pre.rightType = 1;
        }
        pre = node;
        preThreaded(temp);
        preThreaded(node.right);
    }

    //后序线索化二叉树
    public void postThreaded(HeroNode node) {
        if (node == null) { //终止条件
            return;
        }
        postThreaded(node.left);
        postThreaded(node.right);
        //如果左指针为空，就指向前驱节点
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        //如果前驱节点的右指针为空，就指向当前节点
        if (pre != null && pre.right == null) {
            pre.right = node; //pre这里不能是null
            pre.rightType = 1;
        }
        pre = node;
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
