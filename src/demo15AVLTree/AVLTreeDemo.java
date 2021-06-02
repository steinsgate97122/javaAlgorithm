package demo15AVLTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
//        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 11, 7, 6, 8, 9};

        for (int i : arr) {
            avlTree.addNode(new Node(i));
        }

        Node root = avlTree.getRoot();
        System.out.println("根节点的高度：" + root.height());
        System.out.println("左子树高度：" + root.leftHeight());
        System.out.println("右子树高度：" + root.rightHeight());
    }
}
