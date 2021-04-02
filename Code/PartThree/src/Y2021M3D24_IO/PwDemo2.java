package Y2021M3D24_IO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 	在流链接中使用PW
 * @author Grant·Vranes
 *
 */
public class PwDemo2 {
	public static void main(String[] args) throws IOException {
		//下面是个将数据写入文件的操作
		//将字节写入文件
		FileOutputStream fos = new FileOutputStream("pw.txt");
		//将字符转成字节,支持指定字符集
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		//块写
		BufferedWriter bw = new BufferedWriter(osw);
		//自动行刷新
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("一个人的夜，我的心，双手应该放在哪里~");
		System.out.println("写出完毕");
		
		pw.close();//其中已包含flush方法
	}
}
