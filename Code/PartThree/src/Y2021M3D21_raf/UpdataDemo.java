package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 	�޸��ǳ�
 * 	����������Ҫ���û�����Ҫ�޸��ǳƵ��û����Լ��µ��ǳơ�Ȼ�󽫸��û��ǳƽ����޸Ĳ���
 * 	��������û������ڣ�����ʾ���޴��û�����
 * @author Grant��Vranes
 *
 */
public class UpdataDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 1:��ȡ�û�������û��������ǳ�
		 * 2:ʹ��RAF��user.dat�ļ�
		 * 3:ѭ����ȡÿ����¼
		 * 	a:��ָ���ƶ���������¼�û�����λ��(i*100)
		 * 	b:��ȡ32�ֽڣ����û�����ȡ����
		 * 	c:�ж��û����Ƿ�Ϊ�û�������û�
		 * 	d:���Ǵ��ˣ����ƶ�ָ�뵽������¼�ǳ�λ�ã�
		 * 	      �����ǳ���32�ֽ�д���λ�ã�����ԭ�ǳ�����޸ģ�
		 * 	      ��ֹͣѭ������
		 * 	e:�����Ǵ���������´�ѭ��
		 * 
		 * 	�������һ�����أ����޸Ĺ��ǳƺ󣬸ı���ֵ��������ѭ����Ϻ�
		 * 	���ݿ��ص�ֵ�ж��Ƿ����޸���Ϣ��������޴��û���
		 */
		Scanner scanner = new Scanner(System.in);
		System.out.println("����Ҫ���ҵ��û���:");
		String findName = scanner.nextLine();
		
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		boolean flag = false;
		byte[] data = new byte[32];
		for (int i = 0; i < raf.length()/100; i++) {//��Ϊÿ����¼����100�ֽ�
			
			raf.read(data);
			String userName = new String(data,"UTF-8").trim();
			
			if(!findName.equals(userName)) {
				raf.seek(i*100+100);//����ָ��λ�õ���һ����¼
				//System.out.println(raf.getFilePointer());
				continue;
			}else {
				
				//����ָ��λ��
				raf.seek(raf.getFilePointer()+32);//�ƶ���Ҫ�޸ĵļ�¼���ǳƴ�
				raf.read(data);      
				System.out.println("ԭ�ǳƣ�"+new String(data,"UTF-8").trim()+"\n�����޸ĺ���ǳƣ�");
				String Name = scanner.nextLine();
				data = Name.getBytes("UTF-8");//ת�����ƣ�����һ����32�ֽڣ���Ҫ����
				raf.seek(raf.getFilePointer()-32);
				data = Arrays.copyOf(data, 32);//��data���ݵ�32�ֽ�
				raf.write(data);
				System.out.println("�޸ĳɹ�");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("���޴���");
		}
		raf.close();
	}
}
