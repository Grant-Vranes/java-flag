package Y2021M3D24_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java IO(input,output) 输入与输出
 * IO是我们的程序与外界交换数据的方式
 * java提供了一种统一的标准的方式与外界交换数据
 * 
 * java将流按照功能划分为读和写，并用不同的方向来表示
 * 	其中输入流（外借到程序的方向）用于读取数据
 * 	输出流用于写出数据
 * 
 * java将流划分为两大类：节点流，处理流
 * 	节点流：也成为低级流，是实际连接程序与数据源的“管道”，
 * 	负责实际搬运数据。读写一定是建立在节点流（低级流）的基础上进行的
 * 
 * 	处理流：也成为高级流，不能独立存在，必须链接在其他流上，
 * 	目的是当数据流经当前流时对这些数据做某些处理，这样可以
 * 	简化我们对数据的操作
 * 
 * 	实际应用中，我们是链接若干高级流，并最终链接低级流，通过低级流读写
 * 	数据，通过高级流对读写的数据进行某些加工处理，完成一个复杂的读写操作。
 * 	这个过程称为“流链接”。这也是学习IO的精髓所在。
 * 
 * 	文件流：
 * 	文件流是一对低级流，用于读写文件。就功能而言他们和RandomAccessFile
 * 	一致。但是底层的读写方式有本质区别。
 * 		--- RAF是基于指针进行随机（想读哪读哪seek()）读写的，可任意读写文件指定位置的数据。可以做
 * 		到对文件部分数据的编辑操作。
 * 
 * 		---	流是顺序读写方式，所以不能做到任意读写指定位置数据，对此也无法
 * 		做到对文件数据进行编辑的操作。但是配合高级流，可以更轻松地读写数据。
 * @author Grant·Vranes
 *
 */
public class FosDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	使用文件流向文件中写出字节
		 * 	FileOutputStream常见构造方法
		 * 	FileOutputStream(String path)
		 * 	FileOutputStream(File file)
		 * 	以上两种方式创建时，默认为覆盖写操作，即：若创建时发现该文件已存在
		 * 	，会先将该文件所有数据清除。然后将通过当前流写出的内容作为该文件数据。
		 * 
		 * 	FileOutputStream(String pat, boolean append)
		 * 	FileOutputStream(File file, boolean append)
		 * 	追加写模式，即：若指定的文件存在，那么数据全保留，通过该流写出的
		 * 	数据会被追加到文件最后
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt");
		
		String line = "红外俄方回家";
		byte[] data = line.getBytes("UTF-8");//转换成字节
		fos.write(data);
		System.out.println("写出完毕");
		fos.close();
	}
}
