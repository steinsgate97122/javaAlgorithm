package demo03SingleLinkedList;

//将两个有序链表合并，新链表依然有序
public class ListMerge {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "大刀");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "秦明", "霹雳火");
        HeroNode hero8 = new HeroNode(8, "柴进", "小旋风");

        singleLinkedList1.addByOrder(hero1);
        singleLinkedList1.addByOrder(hero7);
        singleLinkedList1.addByOrder(hero4);
        singleLinkedList1.addByOrder(hero5);

        singleLinkedList2.addByOrder(hero2);
        singleLinkedList2.addByOrder(hero8);
        singleLinkedList2.addByOrder(hero3);

        System.out.println("链表1：");
        singleLinkedList1.show();
        System.out.println("链表2：");
        singleLinkedList2.show();
        SingleLinkedList merge;
        if (getLength(singleLinkedList1.head) >= getLength(singleLinkedList2.head)){
            merge = merge(singleLinkedList1, singleLinkedList2);
        }else {
            merge = merge(singleLinkedList2, singleLinkedList1);
        }
        System.out.println("合并：");
        merge.show();
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

    /**
     *
     * @param list1 主链表
     * @param list2 副链表
     * @return list2合并到list1的结果
     */
    public static SingleLinkedList merge(SingleLinkedList list1, SingleLinkedList list2) {
        SingleLinkedList tempList = null;
        tempList = list1;
        if(list2.head.next == null){
            return list1;
        }
        HeroNode cur = list2.head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            tempList.addByOrder(cur);
            cur = next;
        }
        return tempList;
    }
}
