package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 	完成简易记事本工具
 * 	程序启动后，要求用户输入文件名，然后使用RAF对该文件读写操作
 * 	之后用户在控制台输入的每行字符串都写入到该文件中。
 * 	当用户输入了”exit“时，程序退出
 * @author Grant·Vranes
 *
 */
public class Test {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入文件名:");
		String fileName = scanner.nextLine();
		
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		
		System.out.println("请开始输入内容：");
		String line = "";
		while(true) {
			line = scanner.nextLine();
			if("exit".equals(line)) {
				/*
				 * 	注意：
				 * 	因为如果 变量.equals(字面量) 这样写，当变量为null时就会报空指针异常
				 * 	当变量和字面量去equals的时候，推荐用 字面量.equals(变量)
				 * 	这样就算变量为null也不会出错
				 */
				break;
			}
//			byte[] data = line.getBytes("UTF-8");
//			raf.write(data);
			raf.write(line.getBytes("UTF-8"));
		}
		System.out.println("bye");
		raf.close();
	}
	
}
