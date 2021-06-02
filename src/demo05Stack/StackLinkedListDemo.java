package demo05Stack;

import java.util.Scanner;

public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList(new SingleLinkedList());
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String key = "";
        while (loop) {
            System.out.println("pop");
            System.out.println("push");
            System.out.println("show");
            System.out.println("exit");
            System.out.println("请选择：");
            key = sc.next();
            switch (key){
                case "pop":
                    Node node = stackLinkedList.pop();
                    System.out.println(node);
                    break;
                case "push":
                    System.out.println("请输入node编号：");
                    stackLinkedList.push(new Node(sc.nextInt()));
                    break;
                case "show":
                    stackLinkedList.show();
                    break;
                case "exit":
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出了");
    }
}

class StackLinkedList {
    private SingleLinkedList singleLinkedList;

    public void show(){
        singleLinkedList.show();
    }

    public Node pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        Node temp = singleLinkedList.head.next;
        singleLinkedList.head.next = singleLinkedList.head.next.next;
        return temp;
    }

    public void push(Node node){
        node.next = singleLinkedList.head.next;
        singleLinkedList.head.next = node;
    }

    public boolean isEmpty(){
        return singleLinkedList.head.next == null;
    }

    public StackLinkedList(SingleLinkedList singleLinkedList){
        this.singleLinkedList = singleLinkedList;
    }
}

class SingleLinkedList {
    //head节点
    public Node head = new Node(0);

    public void del(int id) {
        Node temp = head;
        boolean flag = false; //是否找到了
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("没有找到id为%d的节点",id);
        }
    }

    public void search(int id) {
        Node temp = head;
        boolean flag = false; //是否查找到了
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println(temp.next);
        }
    }

    public void addByOrder(Node node) {
        Node temp = head;
        boolean flag = false; //是否存在id相同的node
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > node.id) {
                break;
            }
            if (temp.next.id == node.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("编号%d已存在，插入失败。\n", node.id);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

}

class Node {
    public int id;
    public Node next;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}