package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * RAF是专门用来读写文件数据的API。其基于指针对文件
 * 	数据进行读写操作，可以灵活的编辑文件数据内容。
 * 	创建RAF时可以指定对该文件的权限，常用的有两种：
 * r:只读模式
 * rw:读写模式
 * @author Grant·Vranes
 *
 */
public class RafDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	对当前目录中的raf.dat文件读写
		 * RAF支持两种常用构造方法：
		 * RandomAccessFile(File file, String mode)
		 * RandomAccessFile(String path, String mode)
		 * 	注：相对路径中"./"是可以忽略不写的，因为默认就是从当前目录开始
		 * 
		 * RAF创建时含有写权限的情况下，当指定文件不存在时会自动将其创建出来
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		
		/*
		 * void write(int d)
		 * 	向文件中写入1字节，写的是给定的int值对应的2进制的”低八位“
		 * 	如果这个d=2，也是写入一个字节，不过写的就是2对应2进制的”低八位“
		 * 							  vvvvvvvv
		 * 00000000 00000000 00000000 00000000
		 */
		raf.write(1);
		System.out.println("写出完毕");
		raf.close();//释放资源
	}
}
