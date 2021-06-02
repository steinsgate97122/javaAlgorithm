package demo09HashTable;

import java.util.Scanner;

public class HashTab {
    public static void main(String[] args) {
        EmpHashTab empHashTab = new EmpHashTab(7);
        Scanner sc = new Scanner(System.in);
        //为了使用方便，写一个简易操作界面
        while (true){
            System.out.println("add");
            System.out.println("list");
            System.out.println("find");
            System.out.println("del");
            System.out.println("exit");
            String s = sc.next();
            switch (s){
                case "add":
                    System.out.println("输入id：");
                    int id = sc.nextInt();
                    System.out.println("输入姓名：");
                    String name = sc.next();
                    empHashTab.add(new Emp(id,name));
                    break;
                case "list":
                    empHashTab.list();
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                    break;
                case "find":
                    System.out.println("要搜索的元素id：");
                    id = sc.nextInt();
                    empHashTab.searchById(id);
                    break;
                case "del":
                    System.out.println("要删除的元素id：");
                    id = sc.nextInt();
                    empHashTab.delById(id);
                    break;
                default:
                    break;
            }
        }
    }
}

//定义哈希表
class EmpHashTab{
    private EmpLinkedList[] empLinkedListArr;
    private int size;

    public EmpHashTab(int size){ //构造方法
        this.size = size;
        empLinkedListArr = new EmpLinkedList[size];
        for(int i = 0;i<size;i++){
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        //添加元素，首先要明确加入哪一条链表
        int empHashTabNo = hashFunc(emp.id);
        //调用链表的add方法即可
        empLinkedListArr[empHashTabNo].add(emp);
    }

    public int hashFunc(int id){
        return id % size;
    }

    public void list(){
        //显示哈希表
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list();
        }
    }

    public void searchById(int id){
        //先确定id对应哪条链表
        int empHashTabNo = hashFunc(id);
        Emp emp = empLinkedListArr[empHashTabNo].searchById(id);
        //如果emp为空，就没找到
        if(emp != null){
            System.out.printf("在第%d条链表中，找到id为%d的元素\n",empHashTabNo,id);
        }else {
            System.out.println("没有找到");
        }
    }

    public void delById(int id){
        //先确定id对应哪条链表
        int empHashTabNo = hashFunc(id);
        empLinkedListArr[empHashTabNo].delById(id);
    }
}

//定义链表
class EmpLinkedList{
    private Emp head;
    //构造方法就用默认的无参构造，head默认为null就行

    //添加方法
    public void add(Emp emp){
        //判断head是否为空
        if(head == null){
            head = emp;
            return;
        }
        //head不为空，那么需要辅助只能帮助定位到添加点
        Emp cur = head;
        while (true){
            if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        //出while循环时，cur.next指向null
        cur.next = emp;
    }

    //显示方法
    public void list(){
        if(head == null){
            System.out.println("链表为空");
            return;
        }
        Emp cur = head; //辅助指针
        while (true){
            System.out.printf(" => id:%d name:%s\t",cur.id,cur.name);
            if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        //链表输出完毕以后换一行
        System.out.println();
    }

    public Emp searchById(int id){
        //根据id查找相应的元素
        if(head == null){
            //链表为空，返回null
            return null;
        }
        Emp cur = head; //辅助指针
        while (true){
            if(cur.id == id){
                //找到了
                break;
            }
            if(cur.next == null){
                cur = null;
                break;
            }
            cur = cur.next;
        }
        //退出循环时，要么找到了，那么cur就是找到的Emp，要么被赋为null，也直接返回
        return cur;
    }

    public void delById(int id){
        //删掉对应id的元素
        if(head == null){
            System.out.println("链表为空");
            return;
        }
        //如果要删掉的是第一个
        if(head.id == id){
            head = head.next;
            return;
        }
        Emp cur = head;
        //辅助指针定位到要删的节点的前一个位置
        while (true){
            if(cur.next == null){ //搜索完毕，还没有找到id，说明id不存在
                return;
            }
            if(cur.next.id == id){
                break;
            }
            cur = cur.next;
        }
        //代码能执行到这里，说明cur的下一个元素就是要删掉的
        cur.next = cur.next.next;
    }
}

//先把Emp节点定义好
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
        //next默认为null
    }
}