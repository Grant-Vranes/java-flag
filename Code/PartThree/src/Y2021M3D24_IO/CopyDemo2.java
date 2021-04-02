package Y2021M3D24_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 	缓冲流
 * 	缓冲流是一对高级流，功能时提高读写效率。
 * 	连接它们以后，无论我们进行随机读写还是块
 * 	读写，当经过缓冲流时都会被转换为块读写操作
 * 
 * 	java.io.BufferedInputStream
 * 	java.io.BufferedOutputStream
 * @author Grant·Vranes
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("pandoc.msi");
		BufferedInputStream bis = new BufferedInputStream(fis);//缓冲流
		
		FileOutputStream fos = new FileOutputStream("pandoc_cp.msi");
		BufferedOutputStream bos = new BufferedOutputStream(fos);//缓冲流
		
		long start = System.currentTimeMillis();
		
		int len = -1;
		byte[] data = new byte[200];
		while((len=bis.read(data))!=-1) {
			bos.write(data,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕,耗时:"+(end-start)+"ms");//194ms
		bis.close();
		bos.close();
	}
}
