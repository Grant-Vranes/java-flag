package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *	 读取字符串
 * @author Grant·Vranes
 *
 */
public class ReadStringDemo {
	public static void main(String[] args) throws IOException {
		/*
		 *	 将raf.txt文件中的字符读取出来
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		//字符串转换为二进制
		byte[] data = new byte[(int)raf.length()];//这个length方法返回long值
		
		raf.read(data);
		
		//二进制转换成字符串.指定转换的字符集
		String str = new String(data,"UTF-8");
		System.out.println(str);
		raf.close();
		
	}
}
