package Y2021M3D20_file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个文件
 * @author Grant·Vranes
 *
 */
public class CreateNewFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下创建一个名为demo.txt的文件
		 */
		File file = new File("./demo.txt");
		if(!file.exists()) {//检测是否存在该文件
			file.createNewFile();
			System.out.println("文件已创建");
		}else {
			System.out.println("文件已存在");
		}
	}
}
