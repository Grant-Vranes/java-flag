package Y2021M3D24_IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 	����������
 * 	���Խ��ж���ķ����л�������
 * 
 * 	ʹ�ö�������ȡ���ֽڱ�����ͨ��������������л���һ���ֽڲſ���
 * @author Grant��Vranes
 *
 */
public class OisDemo {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("person.object");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Person p = (Person)ois.readObject();
		System.out.println(p);//������ˮ,20,��,[��ѧ��, ��������]
		ois.close();
	}
}