package demo10BinaryTree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "关胜");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "史进");

        // 先手动构造一下树
        root.left = node2;
        root.right = node3;
        node3.right = node4;
        node3.left = node5;

        BinaryTree binaryTree = new BinaryTree(root);
//        HeroNode resNode = binaryTree.postOrderSearch(5);
//        if (resNode == null) {
//            System.out.println("没有找到");
//        } else {
//            System.out.printf("找到了id：%d  name:%s", resNode.id, resNode.name);
//        }
        System.out.println("删除前，前序遍历一下");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历一下");
        binaryTree.preOrder();
    }
}
