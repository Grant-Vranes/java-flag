package Y2021M3D20_file;

import java.io.File;

/**
 * 	完成方法，实现删除给定File所表示的文件或目录
 * @author Grant·Vranes
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir = new File("./a");//a目录下可是有多级目录的
		delete(dir);
	}
	public static void delete(File f) {
		if(f.exists()) {
			if(f.isDirectory()) {//是目录
				//先清空该目录
				File[] subs = f.listFiles();
				for(File file : subs) {
					delete(file);//递归思想
				}
			}
			f.delete();//如果不是目录即文件，直接删除
		}else {
			System.out.println("文件不存在");
		}
	}
}
