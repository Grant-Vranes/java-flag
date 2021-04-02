package Y2021M3D24_IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	转换流---输入流：用于读操作
 * 	java.io.InputStreamReader
 * @author Grant·Vranes
 *
 */
public class IsrDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		
		/*
		 * 	字符流的方法：
		 * 	int read()
		 * 	该方法时一次读取一个字符，实际读取的字节量要根据指定的字符集决定。
		 * 	但是当读取到该字符后再java中都是以一个char形式保存(unicode)占2个字节
		 */
//		int d = -1;
//		while((d=isr.read()) != -1) {//单字节读
//			char c = (char)d;
//			System.out.println(c);
//		}
		
		char[] data = new char[100];//块读
		int len = isr.read(data);
		String str = new String(data,0,len);
		System.out.println(str);
		
		isr.close();
	}
}
