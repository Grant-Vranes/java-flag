package Y2021M3D20_file;

import java.io.File;

/**
 * 	删除目录
 * @author Grant·Vranes
 *
 */
public class DeleteDirDemo {
	public static void main(String[] args) {
		/*
		 * 	删除当前目录下名为demo的目录
		 */
		File dir = new File("./demo");
		if(dir.exists()) {//检测是否存在该目录
			dir.delete();
			/*
			 * 	前提要求：该目录必须是个空目录
			 *	如果不是空目录，该语句也能执行，但是不会进行实际的删除操作，只会返回一个false
			 *	boolean isDelete = dir.delete();//false
			 *	所以说实际的删除不能这么做，要用if判断delete()方法的返回值是否为true
			 */
			System.out.println("删除完毕");
		}else {
			System.out.println("目录不存在");
		}
	}
}
