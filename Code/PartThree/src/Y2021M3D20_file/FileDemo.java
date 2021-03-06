package Y2021M3D20_file;

import java.io.File;

/**
 * java.io.File;
 * File的每一个实例用于表示硬盘上的一个文件或者目录
 * 	使用File可以:
 * 1.访问其表示的文件或目录的属性信息(名字,大小,访问权限等信息)
 * 2.操作文件或目录(创建,删除)
 * 3.访问目录子项
 * 	但是不能访问文件数据
 * @author Grant·Vranes
 *
 */
public class FileDemo {
	/*
	 * 	创建File时，指定的路径通常使用相对路径，好处在于：可以跨平台
	 * 	相对路径到底相对在哪里，要看程序的运行环境指定的位置
	 * 	在ecplise中运行java程序时，指定的行对路径中“当前目录”是当前程序所在的项目目录
	 */
	public static void main(String[] args) {
		/*
		 * 	这个file获取的只是文件在硬盘上的一个映射，它不管有没有这个文件
		 */
		File file = new File("./test.txt");
		
		/*
		 * 	获取文件名getName()
		 */
		String name = file.getName();
		System.out.println(name);
		
		/*
		 * 	获取文件大小(字节量) length()
		 */
		long length = file.length();
		System.out.println(length);
		
		/*
		 * 	获取权限情况
		 */
		boolean cr = file.canRead();//是否可读
		boolean cw = file.canWrite();//是否可写
		System.out.println("可读:"+cr);
		System.out.println("可写:"+cw);
		
		/*
		 * 	是否隐藏
		 */
		boolean ih = file.isHidden();
		System.out.println(ih);
	}
}
