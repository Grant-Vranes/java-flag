package Y2021M3D20_file;

import java.io.File;
import java.io.FileFilter;

/**
 * ListFiles提供了一个重载的方法，可以指定一个文件过滤器(FileFilter),
 *	 然后将满足该过滤器要求的子项返回
 * @author Grant·Vranes
 *
 */
public class ListFilesDemo2 {
	public static void main(String[] args) {
		/*
		 *	 获取当前目录中名字以"."开头的子项
		 */
		File dir = new File(".");//当前目录
		FileFilter filter = new FileFilter() {//匿名内部类
			//重写过滤器类中accept方法
			public boolean accept(File file) {
				String name = file.getName();
				return name.startsWith(".");
			}
		};
//		MyFilter myFilter = new MyFilter();
//		myFilter.accept(dir);
//		File[] subs = dir.listFiles(myFilter);
		File[] subs = dir.listFiles(filter);
		for(File f : subs) {
			System.out.println(f);
		}
	}
}

//class MyFilter implements FileFilter{
//	@Override
//	public boolean accept(File file) {
//		String name = file.getName();
//		return name.startsWith(".");
//	}
//	
//}