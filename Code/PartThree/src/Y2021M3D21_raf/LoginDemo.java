package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *	 完成登录功能
 * @author Grant·Vranes
 *
 */
public class LoginDemo {
	public static void main(String[] args) throws IOException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("登录页面\n请输入用户名:");
		String userName = scanner.nextLine();
		System.out.println("输入密码:");
		String password = scanner.nextLine();
		
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "r");
		boolean flag = false;
		
		for (int i = 0; i < raf.length()/100; i++) {
			//先将指针移动到该条记录的开始位置
			raf.seek(i*100);
			//读取用户名
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"UTF-8").trim();//获取到文件中的用户名
			raf.seek(i*100+32);//移动到密码的位置
			raf.read(data);
			String pwd = new String(data,"UTF-8").trim();//获取密码
			if(userName.equals(name) && password.equals(pwd)) {
				
				System.out.println("登录成功！");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("用户名或密码不正确！");
		}
		raf.close();
	}
}
