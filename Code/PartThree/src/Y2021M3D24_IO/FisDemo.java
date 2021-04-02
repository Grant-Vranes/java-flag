package Y2021M3D24_IO;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 	使用文件输入；流读取文件数据
 * @author Grant·Vranes
 *
 */
public class FisDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		
		byte[] data = new byte[200];
		int len = fis.read(data);

		String str = new String(data,0,len,"UTF-8");//也可以使用后trim消除空格，但是这种要更好
		System.out.println(str);
		fis.close();
	}
}
