package demo03SingleLinkedList;

//单链表反转
public class ReverseLinkedList {
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

        singleLinkedList.show();
        reverse(singleLinkedList.head);
        singleLinkedList.show();
    }

    public static void reverse(HeroNode head){
        if(head.next == null){
            return;
        }
        HeroNode reverseList = new HeroNode(0,"","");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = reverseList.next;
            reverseList.next = cur;
            cur = next;
        }
        head.next = reverseList.next;
    }

}
