package demo02Queue;

import java.util.Scanner;

public class CircleArrayQueue01 {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        char key = ' ';
        while (loop) {
            System.out.println("a(add)");
            System.out.println("s(show)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            System.out.println("e(exit)");
            System.out.println("请选择：");
            key = sc.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入要添加的数");
                    int i = sc.nextInt();
                    queue.addEle(i);
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'g':
                    try {
                        int ele = queue.getEle();
                        System.out.printf("获得:%d\n", ele);
                    } catch (Exception e) {
                        System.out.println(e.getCause());
                    }
                    break;
                case 'h':
                    try {
                        int ele = queue.headQueue();
                        System.out.printf("获得:%d\n", ele);
                    } catch (Exception e) {
                        System.out.println(e.getCause());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("已退出");
    }
}

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addEle(int element) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    public int getEle() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}