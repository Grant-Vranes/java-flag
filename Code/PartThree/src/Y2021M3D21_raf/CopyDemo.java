package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 	复制文件操作
 * 	对于这个程序中的读写操作属于随机读写，从硬盘中的数据
 * 	读一个出来然后又写到硬盘中的另一个文件中去，这样充分
 * 	利用了硬盘的短板，所以在复制的时候非常慢
 * @author Grant·Vranes
 *
 */
public class CopyDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	创建两个RAF，一个用来读原文件，一个用来往复制文件中写。
		 * 	顺序从原文件读取每个字节写入到复制文件中。
		 */
		RandomAccessFile src = new RandomAccessFile("image.JPG", "r");
		RandomAccessFile desc = new RandomAccessFile("image_cp.JPG", "rw");
		
		//记录每次读取到的字节
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read()) != -1) {//直到读完，当src.read()=-1时读完
			desc.write(d);
			/*
			 * 	切记，read和write是读一次写一次
			 * 	有的人可能认为
			 * while(src.read() != -1) {//直到读完，当src.read()=-1时读完
			 *	desc.write(src.read());
			 *	这样也是对的，实际上是错的，第一个read读出
			 *	判断是否读完，第二个接着第一个后面读，所以写入的都是后一个元素
			 */
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕!,耗时:"+(end-start)+"ms");//复制完毕!,耗时:139747ms
		src.close();
		desc.close();
	}
}
