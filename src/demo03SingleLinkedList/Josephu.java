package demo03SingleLinkedList;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(10);
        circleSingleLinkedList.countBoy(1,3,10);
    }
}

class CircleSingleLinkedList {
    private Boy first = null;

    /**
     * @param startNo 开始编号
     * @param countNo 数多少下
     * @param num     人数
     */
    public void countBoy(int startNo, int countNo, int num) {
        //合法性校验省略了
        Boy helper = first;
        for (int i = 0; i < (num - 1); i++) {
            helper = helper.getNext();
        }
        for (int i = 0; i < (startNo - 1); i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //此时fist和helper定位到了开始点
        while (true){
            if(helper.getNext() == helper){
                break;
            }
            for (int i = 0; i < (countNo - 1); i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first所指向的节点出圈
            System.out.println(helper.getNext());
            helper.setNext(helper.getNext().getNext());
        }
        System.out.println(helper);
    }

    public void show() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (cur.getNext() != first) {
            System.out.println(cur);
            cur = cur.getNext();
        }
        System.out.println(cur);
    }

    public void add(int num) {
        if (num < 1) {
            System.out.println("输入有误");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                first = new Boy(1);
                first.setNext(first);
                cur = first;
            } else {
                Boy boy = new Boy(i);
                cur.setNext(boy);
                boy.setNext(first);
                cur = cur.getNext();
            }
        }
    }
}

class Boy {
    private int id;
    private Boy next;

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int id) {
        this.id = id;
    }
}
