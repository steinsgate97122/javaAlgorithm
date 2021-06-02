package demo13HuffmanCoding;

import java.io.*;
import java.util.Map;

public class FileZip {
    public static void zipFile(String srcFile, String dstFile) {
        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            HuffmanCode huffmanCode = new HuffmanCode();
            byte[] zip = huffmanCode.huffmanZip(bytes);
            Map<Byte, String> huffmanCoding = huffmanCode.huffmanCode;
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            Integer res = huffmanCode.res;
            //分别将压缩后的字节数组，编码表和最后一个元素的位数压进dstFile
            oos.writeObject(zip);
            oos.writeObject(huffmanCoding);
            oos.writeObject(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                //非空判断就不写了
                is.close();
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void unzipFile(String srcFile, String dstFile) {
        FileInputStream is = null;
        ObjectInputStream ois = null;
        FileOutputStream fileOutputStream = null;
        try {
            //先用对象输入流读取相关资讯
            is = new FileInputStream(srcFile);
            ois = new ObjectInputStream(is);
            byte[] zip = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCoding = (Map<Byte, String>) ois.readObject();
            Integer res = (Integer) ois.readObject();
            byte[] decode = HuffmanDecode.decode(huffmanCoding, zip, res);
            fileOutputStream = new FileOutputStream(dstFile);
            fileOutputStream.write(decode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                ois.close();
                is.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
