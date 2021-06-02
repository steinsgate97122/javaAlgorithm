package demo05Stack;

import java.util.Scanner;

public class StackArrayDemo {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(4);
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
                    int i = stackArray.pop();
                    System.out.println(i);
                    break;
                case "push":
                    System.out.println("请输入：");
                    stackArray.push(sc.nextInt());
                    break;
                case "show":
                    stackArray.show();
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

class StackArray {
    private int top = -1;
    private int[] arr;
    private int maxSize;

    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = arr[top];
        top--;
        return value;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        arr[top] = value;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
}
