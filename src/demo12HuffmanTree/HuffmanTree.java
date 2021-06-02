package demo12HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};

        Node huffmanTree = createHuffmanTree(arr);
        //用前序遍历检验一下，结果应该是：67，29，38，15，7，8，23，10，4，1，3，6，13
        huffmanTree.preOrder();
    }

    //构造霍夫曼树，返回根节点
    public static Node createHuffmanTree(int[] arr) {
        //先把arr变成Node节点存储在集合中
        List<Node> nodes = new ArrayList<>();

        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes); //排序

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //将这两颗子树合并
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //调整集合
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//创建树节点，实现一下Comparable接口，方便用集合的sort方法排序
class Node implements Comparable<Node> {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //从小到大排序
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    //再写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
