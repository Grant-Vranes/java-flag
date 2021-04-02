package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	若希望提高读写效率，可以通过提高每次实际读写的数据量
 * 	，减少实际发生的读写操作来做到。
 * 	单字节读写：随机读写
 * 	一组字节读写：块读写
 * 	机械硬盘（磁盘）的块读写效率还是比较好的，但是随机读
 * 	写效率极差
 * @author Grant·Vranes
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		
		RandomAccessFile src = new RandomAccessFile("image.JPG", "r");
		RandomAccessFile desc = new RandomAccessFile("image_cp.JPG", "rw");
		
		/*
		 * RAF提供的块读写操作的方法：
		 * int read(byte[] date)
		 * 	一次性读取给定的字节数组长度的字节量并存入到该数组中。返回值为实际
		 *	读取到的字节量，若返回值为-1，表示本次读取是文件末尾（没有督导任何字节）
		 * 
		 * void write(byte[] data)
		 * 	一次性写出给定字节数组中的所有字节
		 * 
		 * void write(byte[] data, int start, int len)
		 * 	一次性写出给定字节数组中从start处开始的len个字节
		 */
		
		//记录每次实际读取到的字节量
		int len = -1;
		//每次要求读取的字节量
		/*
		 * 8位2进制	1byte	1字节
		 * 1024byte	1kb
		 * 1024kb	1mb
		 * 1024mb	1gb
		 * 1024gb	1tb
		 */
		byte[] data = new byte[1024*10];//1024byte*10=10kb
		
		long start = System.currentTimeMillis();
		while((len=src.read(data)) != -1) {
			desc.write(data,0,len);//因为要复制的文件不一定正好是10kb的倍数，所以要注意复制进去的不能多也不能少
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!,耗时:"+(end-start)+"ms");//复制完毕!,耗时:31ms
		src.close();
		desc.close();
	}
}
