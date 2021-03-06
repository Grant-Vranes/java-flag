package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 	完成用户注册功能
 * 	程序开始后，要求用户输入：
 * 	用户名，密码，昵称，年龄
 * 
 * 	将该记录写入到user.dat文件中。
 * 	其中用户名，密码，昵称为字符串。年龄为一个int值
 * 
 * 	每条记录占用100字节，其中：用户名，密码，昵称为字符串
 * 	各占32字节，年龄为int占用4字节
 * @author Grant·Vranes
 *
 */
public class RegDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("欢迎注册");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String userName = scanner.nextLine();
		
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		
		System.out.println("请输入昵称：");
		String nickName = scanner.nextLine();
		
		System.out.println("请输入年龄：");
		int age = Integer.parseInt(scanner.nextLine());
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		/*	每次执行程序的时候（就是每写入一条数据记录的时候），指针都在开头，就
		 * 	造成每写一次之前写的就会被覆盖。所以每一次调用程序都重定指针的位置，使
		 * 	其居于末尾,接着后面写
		 */
		raf.seek(raf.length());
		
		//写用户名
		//1先将用户名转成对应的一组字节
		byte[] data = userName.getBytes("UTF-8");
		//2将该数组扩容为32字节，无论用户名多大，多扩容成32字节，为了确保最后能完整的组成100字节
		data = Arrays.copyOf(data, 32);
		//3将该字节数组一次性写入文件
		raf.write(data);
		
		//写密码，data重新赋值
		data = password.getBytes("UTF-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		
		//写昵称
		data = nickName.getBytes("UTF-8");
		data = Arrays.copyOf(data,32);
		raf.write(data);
		
		//写年龄
		raf.writeInt(age);
		
		System.out.println("注册完毕");
		raf.close();
	}
}
