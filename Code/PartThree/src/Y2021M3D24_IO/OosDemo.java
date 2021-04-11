package Y2021M3D24_IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 	������
 * 	������Ҳ��һ�Ը߼������ṩ�Ĺ����Ƕ�дjava�е��κζ���
 * 
 * 	�����������
 * 	java.io.ObjectOutputStream
 * 	�����Խ�������java����ת��Ϊһ���ֽ�Ȼ��ͨ�������ӵ�������Щ�ֽ�д��
 * 
 * @author Grant��Vranes
 *
 */
public class OosDemo {
	public static void main(String[] args) throws IOException {
		Person  p = new Person();
		p.setName("������ˮ");
		p.setAge(20);
		p.setGender("��");
		
		String[] otherInfo = {"��ѧ��","��������"};
		p.setOtherInfo(otherInfo);
		System.out.println(p);
		
		FileOutputStream fos = new FileOutputStream("person.object");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		/*
		 * 	ͨ��������д��������������������������裺
		 * 	1���������Ƚ������Ķ���ת��Ϊ��һ���ֽڣ������ֽڰ���
		 * 	  �����������������Ϣ���ð����ö���Ľṹ��Ϣ��Ȼ��
		 * 	  �����ֽ�ͨ�������ӵ���д����
		 * 		���������Ķ�Ӧ����������л�
		 * 	2�������ļ���ʱ���ļ����������ֽ�д�뵽���ļ���
		 * 		 ������д����������ñ���Ĺ��̶�Ӧ��������ݳ־û�
		 */
		oos.writeObject(p);
		System.out.println("д�����");
		
		oos.close();
		
	}
}