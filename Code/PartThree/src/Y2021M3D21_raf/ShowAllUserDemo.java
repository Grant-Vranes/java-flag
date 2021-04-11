package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 	��ʾ�û��б�
 * @author Grant��Vranes
 *
 */
public class ShowAllUserDemo {
	public static void main(String[] args) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "r");
		/*
		 * 	ѭ����ȡ���ɸ�100�ֽڣ���Ϊ���Ǿ��ǰ���100�ֽ�һ����¼�洢��
		 */
		for (int i = 0; i < raf.length()/100; i++) {
			//���û���
			//1�ȶ�ȡ32�ֽ�
			byte[] data = new byte[32];
			raf.read(data);
			//2���ֽ�����ת��Ϊ�ַ���
			String userName = new String(data,"UTF-8").trim();
			
			//��ȡ����
			raf.read(data);
			String password = new String(data,"UTF-8").trim();
			
			//���ǳ�
			raf.read(data);
			String nickName = new String(data,"UTF-8").trim();
			
			//������
			int age = raf.readInt();
			System.out.println(userName+","+password+","+nickName+","+age);
			
		}
		
		raf.close();
	}
}
