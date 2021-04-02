package Y2021M3D24_IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	�����ַ���������
 * 	java.io.BufferedReader
 * 	�ص㣺���԰��ж�ȡ�ַ���
 * 
 * @author Grant��Vranes
 *
 */
public class BrDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	����ǰԴ�������������̨
		 */
		FileInputStream fis = new FileInputStream("src/Y2021M3D24_IO/BrDemo.java");
		
		InputStreamReader isr = new InputStreamReader(fis);
		
		BufferedReader br = new BufferedReader(isr);
		
		/*
		 * 	String readLine()
		 * 	��ȡһ���ַ���
		 * 	˳���ȡ�����ַ�������ȡ���˻��з�ʱֹͣ���������з�֮ǰ���ַ����һ���ַ���
		 * 	���ء����ص��ַ������ǲ��������Ļ��з��ġ�������ֵΪnull��˵������ȡ����ĩβ��
		 *	 
		 * 	while(true){
		 * 		String line = br.readLine();
		 * 		System.out.println(line);
		 * 	}
		 * 	��������д�����д���ģ�while(true)�Ǹ�ѭ������br.readLine()����ĩβʱ��
		 * 	���з���ֵnull��ѭ�����ڽ��У���ͳ���һ����ѭ����
		 */
		String line = null;
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}
}
