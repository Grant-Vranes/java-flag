package Y2021M3D20_file;

import java.io.File;

/**
 * 	获取当前目录下的所有子项
 * @author Grant·Vranes
 *
 */
public class ListFilesDemo {
	public static void main(String[] args) {
		File dir = new File(".");
		/*
		 * boolean isFile()
		 * boolean isDirectory()
		 *	判断当前File对象表示的是一个文件还是一个目录
		 */
		if(dir.isDirectory()) {
			File[] subs = dir.listFiles();
			/*
			 * File[] listFiles()
			 * 	该方法会将当前File表示的目录中所有子项返回
			 */
			for(File f : subs) {
				System.out.println(f);
			}
		}
	}
}
