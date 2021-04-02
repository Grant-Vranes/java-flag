package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	读取文件数据
 * @author Grant·Vranes
 *
 */
public class ReadDemo {
	public static void main(String[] args) throws IOException {
		/*
		 *	 读取当前目录中raf.dat文件内容
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		/*
		 * int rand()
		 * 	读取一个字节，并以int形式返回
		 * 	若返回值为-1，则表示读取到了文件末尾
		 */
		int d = raf.read();
		System.out.println(d);
		raf.close();
	}
}
