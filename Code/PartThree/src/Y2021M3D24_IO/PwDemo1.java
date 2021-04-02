package Y2021M3D24_IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * java.io.PrintWriter
 * 	具有自动行刷新的缓冲字符输出流
 * 	开发中比较常用的字符高级流
 * 
 * 	可以按行写出字符串
 * @author Grant·Vranes
 *
 */
public class PwDemo1 {
	public static void main(String[] args) throws IOException, UnsupportedEncodingException {
		/*
		 *	PW提供了专门针对写文件的构造方法
		 *	PrintWriter(String path)
		 *	PrintWriter(File file)
		 */
		PrintWriter pw = new PrintWriter("pw.txt","UTF-8");
		/*查看源码，实际上PrintWriter也调用了FileOutputStream,
		 * OutputStreamWriter,BufferedWriter和他自身。
		 * 
		 * 	而这个指定字符集的参数也是给OutputStreamWriter对象的，因
		 * 	为他是用于转换字节和字符的，需要这个参数，如果没有就是默认字符集。
		 */
		
		pw.println("我的爱滴滴点点~");
		pw.println("圆圆圈圈远远~");
		
		System.out.println("写出完毕");
		pw.close();
	}
}
