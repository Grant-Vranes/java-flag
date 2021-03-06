package Y2021M3D24_IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 	对象输入流
 * 	可以进行对象的反序列化操作。
 * 
 * 	使用对象流读取的字节必须是通过对象输出流序列化的一组字节才可以
 * @author Grant·Vranes
 *
 */
public class OisDemo {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("person.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person p = (Person)ois.readObject();//每次readObject只返回一个对象，可以使用while
		System.out.println(p);//瀑力汽水,20,男,[好学生, 篮球少年]
		ois.close();
	}
}
