package Y2021M3D21_raf;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 	�޸��ǳ�������
 * 	����������Ҫ���û�����Ҫ�޸��ǳƵ��û����Լ��µ��ǳơ�Ȼ�󽫸��û��ǳƽ����޸Ĳ���
 * 	��������û������ڣ�����ʾ���޴��û�����
 * @author Grant��Vranes
 *
 */
public class UpdataDemo2 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����Ҫ���ҵ��û���:");
		String findName = scanner.nextLine();
		System.out.println("�����޸ĺ���ǳ�:");
		String nickname = scanner.nextLine();
		
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		boolean flag = false;
		
		for (int i = 0; i < raf.length()/100; i++) {
			//�Ƚ�ָ���ƶ���������¼�Ŀ�ʼλ��
			raf.seek(i*100);
			//��ȡ�û���
			byte[] data = new byte[32];
			raf.read(data);
			String name = new String(data,"UTF-8").trim();
			if(findName.equals(name)) {
				//�޸��ǳ�
				//1���ƶ�ָ�뵽�ǳƵ�λ��
				raf.seek(i*100+64);
				//2����д�ǳ�32�ֽ�
				data = nickname.getBytes("UTF-8");
				data = Arrays.copyOf(data, 32);//��data���ݵ�32�ֽ�
				raf.write(data);
				System.out.println("�޸ĳɹ�");
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("�޴��û���");
		}
		raf.close();
	}
}
