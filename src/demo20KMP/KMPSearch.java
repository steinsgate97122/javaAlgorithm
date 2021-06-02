package demo20KMP;

public class KMPSearch {

    public static void main(String[] args) {
        //测试一下getNext方法
//        String p = "DABCDABDE";
//        int[] next = new KMPSearch().getNext(p);
//        System.out.println(Arrays.toString(next));
        //测试一下KMP算法
        String str1 = "001 201320 201320132034";
        String str2 = "2013203";
        System.out.println(new KMPSearch().kmpSearch(str1, str2));
    }

    //判断str1中是否含有str2，如果是，返回在str1中第一次出现的位置，否则返回-1
    //用KMP算法来实现
    public int kmpSearch(String str1, String str2) {
        //1.先将两个字符串给转换为char数组
        char[] s = str1.toCharArray();
        char[] p = str2.toCharArray();
        int sLen = s.length;
        int pLen = p.length;
        //2.得到p的next数组
        int[] next = new KMPSearch().getNext(str2);
        //3.指针初始化
        int i = 0;
        int j = 0;
        //4.遍历两个字符串
        while (i < sLen && j < pLen) {
            if (j == -1 || s[i] == p[j]) {
                //j等于-1代表此时前缀完全不匹配，直接让i和j向后匹配
                i++;
                j++;
            } else {
                //j不等于-1，并且此时两个字符串的对应位不匹配，则让j找到此时相同的前后缀长度，并回溯这个长度
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    //通过字符串得到相应的next数组
    public int[] getNext(String str) {
        //1.将字符串转换为字符数组
        char[] p = str.toCharArray();
        int strLen = p.length;
        //2.初始化next数组
        int[] next = new int[strLen];
        //3.初始化2个指针，j指向需要得到的next数组，k记录上一个next的值
        int j = 0;
        int k = -1;
        next[0] = -1;
        while (j < strLen - 1) {
            //如果匹配上了，或者k递归完毕，就可以计算next[j]的值
            if (k == -1 || p[k] == p[j]) {
                j++;
                k++;
                next[j] = k;
            } else {
                //没有匹配上，k递归，找到P0P1...Pk-1的相同前后缀
                k = next[k];
            }
        }
        //4.返回next数组
        return next;
    }
}

