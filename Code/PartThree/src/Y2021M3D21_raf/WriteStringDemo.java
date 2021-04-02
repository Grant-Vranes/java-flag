package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	写出字符串操作
 * @author Grant·Vranes
 *
 */
public class WriteStringDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		String line = "大家好!";
		/*
		 * String提供了转换为2进制的方法:
		 * byte[] getBytes();
		 */
//		byte[] data = line.getBytes();//不推荐无参的，以后在做网络编程的时候很可能字符集不匹配造成的乱码
		byte[] data = line.getBytes("UTF-8");//指定字符集,UTF-8一个字符占3个字节
		
		raf.write(data);
		System.out.println("写出完毕");
		raf.close();
	}
}
