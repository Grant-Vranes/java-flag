package Y2021M3D24_IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 	缓冲输出流的缓冲区问题
 * @author Grant·Vranes
 *
 */
public class Bos_flushDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		String line = "我喜欢这样看着你，随便你带我到哪里";
		byte[] data = line.getBytes("UTF-8");
		/*
		 * 	缓冲流的write方法并不是立即将数据写出的，而是先将数据存入其内部的数组中，
		 * 	当数组装满时(默认8kb装满写一次)才会做一次真实的写操作。（转化为块写操作的过程）
		 */
		bos.write(data);
		/*
		 * flush方法的意义是强制将缓冲流已经缓存的数据一次性写出。这样做可以让
		 * 	写出的数据有即时性，但是频繁调用会降低写效率。在更关注写出的即时性时应当使用此方法
		 */
		//bos.flush();
		System.out.println("写出完毕");
		/*
		 * close方法中会调用一次flush方法
		 */
		bos.close();
	}
}
