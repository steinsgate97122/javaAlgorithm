package demo14BinarySortTree;

public class BSTDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();

        for (int i : arr) {
            binarySortTree.addNode(new Node(i));
        }

//        binarySortTree.delNode(2);
//        binarySortTree.delNode(5);
//        binarySortTree.delNode(9);
//        binarySortTree.delNode(12);
        binarySortTree.delNode(7);
        binarySortTree.infixOrder();
    }
}
