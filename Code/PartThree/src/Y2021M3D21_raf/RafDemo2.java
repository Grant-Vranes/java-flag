package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF读写基本类型数据，以及RAF的指针操作
 * @author Grant·Vranes
 *
 */
public class RafDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		
		//获取指针
		long pos = raf.getFilePointer();
		System.out.println("pos:" + pos);//0
		
		//写入一个int的最大值到文件中
		int max = Integer.MAX_VALUE;
		/*
		 * int 最大值的2进制形式
		 * 							  vvvvvvvv
		 * 01111111 11111111 11111111 11111111
		 * max>>>24右移24位					   V溢出
		 * 00000000 00000000 00000000 01111111 11111111 11111111 11111111
		 * max>>>16							   V溢出	
		 * 00000000 00000000 01111111 11111111 11111111 11111111
		 * max>>>8							   V溢出
		 * 00000000 01111111 11111111 11111111 11111111
		 * max>>>0
		 * 01111111 11111111 11111111 11111111
		 */
		
		/*
		 * raf.write(max);//写入操作
		 * void write(int d)
		 * 	向文件中写入1字节，写的是给定的int值对应的2进制的”低八位“
		 * 	所以此处写入的并不是正确的int最大值，只是int的低八位
		 * 	知道了write的这个特性，我们就可以使用位运算，一段一段的写入
		 */
		raf.write(max>>>24);
		System.out.println("pos:" + raf.getFilePointer());
		raf.write(max>>>16);
		System.out.println("pos:" + raf.getFilePointer());
		raf.write(max>>>8);
		System.out.println("pos:" + raf.getFilePointer());
		raf.write(max);
		System.out.println("pos:" + raf.getFilePointer());
		
		/*
		 * void writeInt(int d)
		 * 	连续写出4个字节(32位)，将给定的int值输出
		 * 	等同于上面4行write方法，但本质上还是这个处理过程
		 */
		raf.writeInt(max);
		System.out.println("pos:" + raf.getFilePointer());
		raf.writeLong(123L);
		System.out.println("pos:" + raf.getFilePointer());
		raf.writeDouble(123.123);
		System.out.println("pos:" + raf.getFilePointer());;
		
		System.out.println("写出完毕！");
		
		/*
		 *	 读一个字节，发现其返回值为-1，说明读到了文件末尾，
		 *	这是因为raf中有指针的概念，上面写入操作的的时候，
		 *	指针已经到了文件末尾，所以再次读的时候，从指针开始读
		 *	RandomAccessFile总是在当前指针的位置进行读和写
		 */
		int d = raf.read();
		System.out.println(d);//-1
		
		d = raf.readInt();//读四个字节
		System.out.println(d);//报错
		/*	java.io.EOFException,(end of file),
		 * 	使用除read()外的readXXX()方法读到末尾都会这样报错
		 */
		
		//移动指针位置
		raf.seek(0);//移动到文件开始的位置
		d = raf.readInt();//读四个字节
		System.out.println(d);
		
		raf.seek(0);
		long l = raf.readLong();//读八个字节
		System.out.println(l);//这个读出来的结果并不是前两个writeInt的值，某种意义上来说也是一种乱码，用什么写的就用什么读
		
		raf.close();
	}
}
