package Y2021M3D24_IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	缓冲字符输入流：
 * 	java.io.BufferedReader
 * 	特点：可以按行读取字符串
 * 
 * @author Grant·Vranes
 *
 */
public class BrDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	将当前源代码输出到控制台
		 */
		FileInputStream fis = new FileInputStream("src/Y2021M3D24_IO/BrDemo.java");
		
		InputStreamReader isr = new InputStreamReader(fis);
		
		BufferedReader br = new BufferedReader(isr);
		
		/*
		 * 	String readLine()
		 * 	读取一行字符串
		 * 	顺序读取若干字符，当读取到了换行符时停止，并将换行符之前的字符组成一个字符串
		 * 	返回。返回的字符串中是不含有最后的换行符的。若返回值为null，说明流读取到了末尾。
		 *	 
		 * 	while(true){
		 * 		String line = br.readLine();
		 * 		System.out.println(line);
		 * 	}
		 * 	上面这种写法是有错误的，while(true)是个循环，而br.readLine()读到末尾时，
		 * 	还有返回值null，循环仍在进行，这就成了一个死循环。
		 */
		String line = null;
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
