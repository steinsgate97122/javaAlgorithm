package demo13HuffmanCoding;

import java.util.Arrays;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        String str = "Whatever is worth doing is worth doing well";
//        String str = "i like like like java do you like a java";
        HuffmanCode huffmanCode = new HuffmanCode();
        byte[] zip = huffmanCode.huffmanZip(str.getBytes());
        Map<Byte, String> map = huffmanCode.huffmanCode;
        Integer res = huffmanCode.res;
        System.out.println(Arrays.toString(zip));

        byte[] decode = HuffmanDecode.decode(map, zip, res);
        System.out.println(new String(decode));
    }
}
