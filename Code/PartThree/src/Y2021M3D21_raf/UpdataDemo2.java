package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 	修改昵称做法二
 * 	程序启动后，要求用户输入要修改昵称的用户名以及新的昵称。然后将该用户昵称进行修改操作
 * 	若输入的用户不存在，则提示“无此用户”。
 * @author Grant·Vranes
 *
 */
public class UpdataDemo2 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入要查找的用户名:");
		String findName = scanner.nextLine();
		System.out.println("输入修改后的昵称:");
		String nickname = scanner.nextLine();
		
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		boolean flag = false;
		
		for (int i = 0; i < raf.length()/100; i++) {
			//先将指针移动到该条记录的开始位置
			raf.seek(i*100);
			//读取用户名
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"UTF-8").trim();
			if(findName.equals(name)) {
				//修改昵称
				//1先移动指针到昵称的位置
				raf.seek(i*100+64);
				//2重新写昵称32字节
				data = nickname.getBytes("UTF-8");
				data = Arrays.copyOf(data, 32);//把data扩容到32字节
				raf.write(data);
				System.out.println("修改成功");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("无此用户！");
		}
		raf.close();
	}
}
