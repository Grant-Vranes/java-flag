package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 	修改昵称
 * 	程序启动后，要求用户输入要修改昵称的用户名以及新的昵称。然后将该用户昵称进行修改操作
 * 	若输入的用户不存在，则提示“无此用户”。
 * @author Grant·Vranes
 *
 */
public class UpdataDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 1:获取用户输入的用户名及新昵称
		 * 2:使用RAF打开user.dat文件
		 * 3:循环读取每条记录
		 * 	a:将指针移动到该条记录用户名的位置(i*100)
		 * 	b:读取32字节，将用户名读取出来
		 * 	c:判断用户名是否为用户输入的用户
		 * 	d:若是此人，则移动指针到该条记录昵称位置，
		 * 	      将新昵称以32字节写入该位置，覆盖原昵称完成修改，
		 * 	      并停止循环操作
		 * 	e:若不是此人则进入下次循环
		 * 
		 * 	可以添加一个开关，当修改过昵称后，改变其值，最终在循环完毕后，
		 * 	根据开关的值判定是否有修改信息来输出“无此用户”
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入要查找的用户名:");
		String findName = scanner.nextLine();
		
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		boolean flag = false;
		byte[] data = new byte[32];
		for (int i = 0; i < raf.length()/100; i++) {//因为每条记录都是100字节
			
			raf.read(data);
			String userName = new String(data,"UTF-8").trim();
			
			if(!findName.equals(userName)) {
				raf.seek(i*100+100);//调整指针位置到下一条记录
				//System.out.println(raf.getFilePointer());
				continue;
			}else {
				
				//调整指针位置
				raf.seek(raf.getFilePointer()+32);//移动到要修改的记录的昵称处
				raf.read(data);      
				System.out.println("原昵称："+new String(data,"UTF-8").trim()+"\n输入修改后的昵称：");
				String Name = scanner.nextLine();
				data = Name.getBytes("UTF-8");//转二进制，但不一定是32字节，需要扩容
				raf.seek(raf.getFilePointer()-32);
				data = Arrays.copyOf(data, 32);//把data扩容到32字节
				raf.write(data);
				System.out.println("修改成功");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("查无此人");
		}
		raf.close();
	}
}
