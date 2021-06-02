package demo13HuffmanCoding;

import java.util.*;

public class HuffmanCode {
    public Node root; //哈夫曼树的根节点
    public List<Node> nodes;
    public Integer res;

    //将字节数组转换为node的集合返回
    public List<Node> getNodes(byte[] bytes) {
        // 统计每个字符的出现次数
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            if (map.get(b) == null) {
                map.put(b, 1);
            } else {
                map.put(b, map.get(b) + 1);
            }
        }
        //将所有键值对转化为node节点
        ArrayList<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        this.nodes = nodes;
        return nodes;
    }

    // 创建哈夫曼树
    public void createHuffmanTree() {
        ArrayList<Node> nodes = new ArrayList<>(this.nodes);
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        this.root = nodes.get(0);
    }

    // 获得哈夫曼编码表，用Map集合存储
    Map<Byte, String> huffmanCode = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();

    /**
     * @param node          遍历到了当前节点
     * @param code          当前节点上面的路径是0还是1
     * @param stringBuilder 节点前的历史字符数组
     */
    public void getCode(Node node, String code, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        //判断node是否是叶子节点
        if (node.data == null) { //非叶子节点，向左向右递归
            getCode(node.left, "0", stringBuilder2);
            getCode(node.right, "1", stringBuilder2);
        } else { //叶子节点，加入到map集合中
            huffmanCode.put(node.data, stringBuilder2.toString());
        }
    }

    //上面的getNode方法调用不方便，重载一下，接收root节点，返回哈夫曼编码表
    public Map<Byte, String> getCode(Node root) {
        if (root == null) {
            System.out.println("树为空");
            return null;
        }
        getCode(root.left, "0", stringBuilder);
        getCode(root.right, "1", stringBuilder);
        return huffmanCode;
    }

    //码表获取后，对字符数组进行编码
    public byte[] zip(byte[] bytes) {
        //先将01形式的字符串存储起来
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCode.get(b));
        }
//        System.out.println(stringBuilder);
        // 统计需要多长的字节数组存储
        int len;
        len = stringBuilder.length() / 8;
        if (len * 8 != stringBuilder.length()) {
            len += 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            if (i + 8 > stringBuilder.length()) {
                huffmanCodeBytes[index] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
                this.res = stringBuilder.length()-i;
            } else {
                huffmanCodeBytes[index] = (byte) Integer.parseInt(stringBuilder.substring(i, i + 8), 2);
            }
            index++;
        }
        return huffmanCodeBytes;
    }

    // 将编码过程封装一下
    public byte[] huffmanZip(byte[] bytes) {
        getNodes(bytes);
        createHuffmanTree();
        getCode(root);
        return zip(bytes);
    }
}
