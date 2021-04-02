package Y2021M3D24_IO;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 	完成简易记事本工具
 * 	程序启动后，要求用户输入文件名，然后对该文件进行写操作。
 * 	之后用户输入的每一行字符串都按行写入到该文件中。
 * 	创建PW时要求使用流链接模式
 * @author Grant·Vranes
 *
 */
public class PwTest {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("简易记事本，请输入文件名:");
		String fileName = scanner.nextLine();
		
		FileOutputStream fos = new FileOutputStream(fileName);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		/*
		 * 	当在流链接当中创建PrintWriter时允许指定第二个参数，该参数
		 * 	为一个boolean值，当这个值为true时，当前PW具有自动行刷新功能
		 * 	即：每当调用println方法写出一行字符串时就会自动flush，流做
		 * 	   真实写操作，但一旦真实写操作频繁了，效率就会下降。但用不用看你取
		 * 	   决于什么方向，如果是关注消息的即时性，就要用。
		 * 	注意：print方法是不会自动flush的
		 */
		PrintWriter pw = new PrintWriter(bw,true);
		
		System.out.println("---------Ins----------");
		String info = null;
		while(true) {
			info = scanner.nextLine();
			if("exit".equals(info)) {
				break;
			}
			pw.println(info);
			pw.flush();
		}
		System.out.println("编辑完毕");
		pw.close();
	}
}
