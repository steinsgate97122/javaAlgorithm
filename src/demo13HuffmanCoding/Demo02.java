package demo13HuffmanCoding;

public class Demo02 {
    public static void main(String[] args) {
//        String srcPath1 = "algo\\src\\demo13HuffmanCoding\\test_zip.bmp";
//        String dstPath1 = "algo\\src\\demo13HuffmanCoding\\test_zip.zip";
//        FileZip.zipFile(srcPath1,dstPath1);

        String srcPath2 = "algo\\src\\demo13HuffmanCoding\\test_zip.zip";
        String dstPath2 = "algo\\src\\demo13HuffmanCoding\\test_zip2.bmp";
        FileZip.unzipFile(srcPath2,dstPath2);
    }
}
