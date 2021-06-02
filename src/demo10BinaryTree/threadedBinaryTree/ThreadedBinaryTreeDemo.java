package demo10BinaryTree.threadedBinaryTree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "关胜");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "史进");

        // 手动构造树
        root.left = node2;
        root.right = node3;
        node3.right = node4;
        node3.left = node5;

        BinaryTree binaryTree = new BinaryTree(root);

        binaryTree.infixThreaded(root);
        binaryTree.infixThreadedList();

//        binaryTree.preThreaded(root);
//        binaryTree.preThreadedList();

//        binaryTree.postThreaded(root);
//        binaryTree.postThreadedList();
    }
}
