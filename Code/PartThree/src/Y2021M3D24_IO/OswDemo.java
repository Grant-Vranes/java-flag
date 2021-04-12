package Y2021M3D24_IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 	字符流
 * java将流按照读写单位又进行了一种划分方式
 * 	字节流和字符流
 * 	字节流的读写单位是字节，而字符流的读写单位是字符
 * 	所以字符流只适合读写文本数据！
 * 
 * java.io.Reader	java.io.Writer
 * 	这两个类也是抽象类，是所有字符输入流与字符输出流的父类，
 *	 规定了读写字符的相关方法
 * 
 *	 转换流
 * java.io.InputStreamReader
 * java.io.OutputStreamWriter
 *	 他们是一对常用的字符流实现类，经常在我们做字符数据读写操作中使用。
 * 	并且在流链接中是非常重要的一个环节。但是我们很少直接对他做操作。
 * @author Administrator
 *
 */
public class OswDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		
		String line = "我直接好家伙";
		
//		byte[] data = line.getBytes("UTF-8");//转换为字节
//		fos.write(data);//写入
		osw.write(line);//帮助转换为字节，使用字节流可以直接写入字符串，不用像上两句一样转换为字节项
		
		System.out.println("写出完毕");
//		fos.close();
		osw.close();
	}
}
