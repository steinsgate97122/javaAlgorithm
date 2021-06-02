package demo03SingleLinkedList;

public class SingleLinkedList01 {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        singleLinkedList.update(new HeroNode(4, "林林", "豹豹"));

//        singleLinkedList.search(4);
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.show();
    }
}

class SingleLinkedList {
    //head节点
    public HeroNode head = new HeroNode(0, "", "");

    public void del(int id) {
        HeroNode temp = head;
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

    public void update(HeroNode newHeroNode) {
        HeroNode temp = head.next;
        boolean flag = false; //是否查找到了
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
            System.out.printf("没有找到id为%d的节点\n", newHeroNode.id);
        }
    }

    public void search(int id) {
        HeroNode temp = head;
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

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; //是否存在id相同的node
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > heroNode.id) {
                break;
            }
            if (temp.next.id == heroNode.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("编号%d已存在，插入失败。\n", heroNode.id);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void show() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

}

class HeroNode {
    public int id;
    public String name;
    public String nickName;
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