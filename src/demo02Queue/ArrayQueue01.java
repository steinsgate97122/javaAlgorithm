package demo02Queue;

import java.util.Scanner;

public class ArrayQueue01 {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        char key=' ';
        while (loop){
            System.out.println("a(add)");
            System.out.println("s(show)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            System.out.println("e(exit)");
            System.out.println("请选择：");
            key = sc.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.println("输入要添加的数");
                    int i = sc.nextInt();
                    queue.addEle(i);
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'g':
                    try{
                        int ele = queue.getEle();
                        System.out.printf("获得:%d\n",ele);
                    }catch (Exception e){
                        System.out.println(e.getCause());
                    }
                    break;
                case 'h':
                    try{
                        int ele = queue.headQueue();
                        System.out.printf("获得:%d\n",ele);
                    }catch (Exception e){
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

    static class ArrayQueue{
        private int maxSize;
        private int front;
        private int rear;
        private int[] arr;

        public ArrayQueue(int maxSize){
            this.maxSize = maxSize;
            front = -1;
            rear = -1;
            arr = new int[maxSize];
        }

        public boolean isFull(){
            return rear == (maxSize-1);
        }

        public boolean isEmpty(){
            return (rear == front);
        }

        public void addEle(int element){
            if(isFull()){
                System.out.println("队列已满");
                return;
            }
            rear++;
            arr[rear] = element;
        }

        public int getEle(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            front++;
            return arr[front];
        }

        public void showQueue(){
            if(isEmpty()){
                System.out.println("队列为空");
                return;
            }
            for(int i = front+1;i<=rear;i++){
                System.out.printf("%d\t",arr[i]);
            }
            System.out.println();
        }

        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空");
            }
            return arr[front+1];
        }
    }
}
