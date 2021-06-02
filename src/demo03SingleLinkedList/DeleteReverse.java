package demo03SingleLinkedList;

//删除单链表中倒数第k个节点
public class DeleteReverse {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        delete(singleLinkedList.head,2);

        singleLinkedList.show();
    }

    public static void delete(HeroNode head, int index) {
        if (head.next == null) {
            return;
        }
        HeroNode cur = head;
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return;
        }
        for (int i = 0; i < (size - index); i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode cur = head.next;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
