package demo04DoubleLinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(4, "公孙胜", "入云龙");

        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);

        doubleLinkedList.update(hero5);
//        doubleLinkedList.del(1);
//        doubleLinkedList.del(4);
//        doubleLinkedList.del(2);
//        doubleLinkedList.del(3);

        //正序
        doubleLinkedList.show();
        //逆序
        System.out.println("==================");
        doubleLinkedList.show02();
    }
}

class DoubleLinkedList {
    public HeroNode head = new HeroNode(0, "", "");

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head.next;
        boolean flag = true;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == heroNode.id) {
                flag = false;
                break;
            }
            if (temp.id > heroNode.id) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //增加到temp前面
            if (temp != null) {
                temp.pre.next = heroNode;
                heroNode.pre = temp.pre;
                heroNode.next = temp;
                temp.pre = heroNode;
            } else {
                add(heroNode);
            }
        } else {
            System.out.printf("编号为%d的节点已存在\n", heroNode.id);
        }
    }

    public void del(int id) {
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //删掉temp节点
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没有找到%d编号的节点\n", id);
        }
    }

    public void update(HeroNode newHeroNode) {
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == newHeroNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到%d编号的节点\n", newHeroNode.id);
        }
    }

    public void show() {
        if (head.next == null) {
            System.out.println("列表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void show02() {
        if (head.next == null) {
            System.out.println("列表为空");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp.pre != null) {
            System.out.println(temp);
            temp = temp.pre;
        }
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
}

class HeroNode {
    public int id;
    public String name;
    public String nickName;
    public HeroNode pre;
    public HeroNode next;

    public HeroNode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
