package demo20KMP;

public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "001 201320 201320132034";
        String str2 = "2013203";
        System.out.println(new ViolenceMatch().violenceMatch(str1,str2)); //希望输出15
    }

    //判断str1中是否含有str2，如果是，返回在str1中第一次出现的位置，否则返回-1
    //先用暴力匹配法实现一下
    public int violenceMatch(String str1, String str2) {
        //先把String转化为char数组
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while (i < charStr1.length && j < charStr2.length) {
            if (charStr1[i] == charStr2[j]) { //当前字符匹配上了
                i++;
                j++;
            } else {
                //没有匹配上，回滚
                i = i - j + 1;
                j = 0;
            }
            //判断是否匹配成功，如果没有，继续下一次循环
            if (j == charStr2.length) {
                return i - j;
            }
        }
        //出循环还没匹配上
        return -1;
    }
}
