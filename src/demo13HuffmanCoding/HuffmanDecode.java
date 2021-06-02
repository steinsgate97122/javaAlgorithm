package demo13HuffmanCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HuffmanDecode {
    //先写一个方法，用来将一个byte字节转为二进制码
    public static String byteToBitString(byte b, int numOfBits) {
        int temp = b;
        temp |= 256;
        String binaryString = Integer.toBinaryString(temp);
        return binaryString.substring(binaryString.length() - numOfBits);
    }

    //解码的方法
    public static byte[] decode(Map<Byte,String> huffmanCodes, byte[] huffmanBytes, int numOfBits){
        StringBuilder stringBuilder = new StringBuilder();
        String bitString;
        for(int i =0;i<huffmanBytes.length;i++){
            byte b = huffmanBytes[i];
            if(i == huffmanBytes.length-1){
                bitString = byteToBitString(b, numOfBits);
            }else {
                bitString = byteToBitString(b, 8);
            }
            stringBuilder.append(bitString);
        }

        //反转map集合
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }
        //解码
        ArrayList<Byte> list = new ArrayList<>();
        for(int i = 0;i<stringBuilder.length();){
            boolean flag = true;
            int count = 1;
            while (flag){
                String key = stringBuilder.substring(i, i + count);
                Byte b = map.get(key);
                if(b == null){
                    count++;
                }else {
                    list.add(b);
                    flag = false;
                }
            }//出循环后，用掉了count个位进行匹配
            i += count;
        }
        byte[] bytes = new byte[list.size()];
        for(int i = 0;i<list.size();i++){
            bytes[i] = list.get(i);
        }
        return bytes;
    }
}
