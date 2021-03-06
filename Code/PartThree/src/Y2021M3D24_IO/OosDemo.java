package Y2021M3D24_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 	对象流
 * 	对象流也是一对高级流，提供的功能是读写java中的任何对象
 * 
 * 	对象输出流：
 * 	java.io.ObjectOutputStream
 * 	它可以将给定的java对象转换为一组字节然后通过其连接的流将这些字节写出
 * 
 * @author Grant·Vranes
 *
 */
public class OosDemo {
	public static void main(String[] args) throws IOException {
		Person  p = new Person();
		p.setName("瀑力汽水");
		p.setAge(20);
		p.setGender("男");
		
		String[] otherInfo = {"好学生","篮球少年"};
		p.setOtherInfo(otherInfo);
		System.out.println(p);

		FileOutputStream fos = new FileOutputStream("person.object");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * 	通过对象流写出对象这个方法经历了两个步骤：
		 * 	1：对象流先将给定的对象转换为了一组字节，这组字节包含
		 * 	  对象本身保存的数据信息，好包含该对象的结构信息，然后将
		 * 	  这组字节通过其连接的流写出。
		 * 		上述操作的对应术语：对象序列化
		 * 	2：经过文件流时，文件流将这组字节写入到了文件中
		 * 		 将数据写入磁盘做长久保存的过程对应的术语：数据持久化
		 */
		oos.writeObject(p);
		System.out.println("写出完毕");
		
		oos.close();
		
	}
}
