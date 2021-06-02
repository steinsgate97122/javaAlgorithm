package demo10BinaryTree;

public class ArrBinaryDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder(0);
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历，参数n表示从哪一个数组元素开始遍历
    public void preOrder(int n) {
        //先判断一下，如果arr为空，那么就不用遍历了
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        //进行前序遍历，先遍历到当前节点
        System.out.println(arr[n]);
        //向左子节点递归，注意索引不能越界
        if (n * 2 + 1 < arr.length) {
            preOrder(n * 2 + 1);
        }
        //向右子节点递归
        if (n * 2 + 2 < arr.length) {
            preOrder(n * 2 + 2);
        }
    }

    // 重载一个无参的，调用起来方便一点
    public void preOrder(){
        preOrder(0);
    }

    //中序遍历，参数n表示从哪一个数组元素开始遍历
    public void infixOrder(int n) {
        //先判断一下，如果arr为空，那么就不用遍历了
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        //进行中序遍历
        //向左子节点递归，注意索引不能越界
        if (n * 2 + 1 < arr.length) {
            infixOrder(n * 2 + 1);
        }
        System.out.println(arr[n]);
        //向右子节点递归
        if (n * 2 + 2 < arr.length) {
            infixOrder(n * 2 + 2);
        }
    }

    //后序遍历，参数n表示从哪一个数组元素开始遍历
    public void postOrder(int n) {
        //先判断一下，如果arr为空，那么就不用遍历了
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        //进行后序遍历
        //向左子节点递归，注意索引不能越界
        if (n * 2 + 1 < arr.length) {
            postOrder(n * 2 + 1);
        }
        //向右子节点递归
        if (n * 2 + 2 < arr.length) {
            postOrder(n * 2 + 2);
        }
        System.out.println(arr[n]);
    }
}