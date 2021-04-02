package Y2021M3D20_file;

import java.io.File;

/**
 * 删除一个文件
 * @author Grant·Vranes
 *
 */
public class DeleteFileDemo {
	public static void main(String[] args) {
		/*
		 * 将当前目录下的demo.txt文件删除
		 */
		File file = new File("./demo.txt");
		if(file.exists()) {//检测是否存在该文件
			file.delete();
			System.out.println("文件已删除");
		}else {
			System.out.println("文件不存在");
		}
	}
}
