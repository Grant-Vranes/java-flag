package Y2021M3D20_file;

import java.io.File;

/**
 * 创建一个目录
 * @author Grant·Vranes
 *
 */
public class MKDirDemo {
	public static void main(String[] args) {
		/*
		 * 将当前目录下创建一个名为demo的目录
		 */
		File dir = new File("./demo");
		if(!dir.exists()) {//检测是否存在该文件
			dir.mkdir();
			System.out.println("目录创建完毕");
		}else {
			System.out.println("目录已存在");
		}
	}
}
