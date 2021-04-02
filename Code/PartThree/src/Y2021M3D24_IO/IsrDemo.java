package Y2021M3D24_IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	ת����---�����������ڶ�����
 * 	java.io.InputStreamReader
 * @author Grant��Vranes
 *
 */
public class IsrDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		
		/*
		 * 	�ַ����ķ�����
		 * 	int read()
		 * 	�÷���ʱһ�ζ�ȡһ���ַ���ʵ�ʶ�ȡ���ֽ���Ҫ����ָ�����ַ���������
		 * 	���ǵ���ȡ�����ַ�����java�ж�����һ��char��ʽ����(unicode)ռ2���ֽ�
		 */
//		int d = -1;
//		while((d=isr.read()) != -1) {//���ֽڶ�
//			char c = (char)d;
//			System.out.println(c);
//		}
		
		char[] data = new char[100];//���
		int len = isr.read(data);
		String str = new String(data,0,len);
		System.out.println(str);
		
		isr.close();
	}
}
