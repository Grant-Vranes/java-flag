package Y2021M3D24_IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 	�ַ���
 * java�������ն�д��λ�ֽ�����һ�ֻ��ַ�ʽ
 * 	�ֽ������ַ���
 * 	�ֽ����Ķ�д��λ���ֽڣ����ַ����Ķ�д��λ���ַ�
 * 	�����ַ���ֻ�ʺ϶�д�ı����ݣ�
 * 
 * java.io.Reader	java.io.Writer
 * 	��������Ҳ�ǳ����࣬�������ַ����������ַ�������ĸ��࣬
 *	 �涨�˶�д�ַ�����ط���
 * 
 *	 ת����
 * java.io.InputStreamReader
 * java.io.OutputStreamWriter
 *	 ������һ�Գ��õ��ַ���ʵ���࣬�������������ַ����ݶ�д������ʹ�á�
 * 	���������������Ƿǳ���Ҫ��һ�����ڡ��������Ǻ���ֱ�Ӷ�����������
 * @author Administrator
 *
 */
public class OswDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		
		String line = "��ֱ�Ӻüһ�";
		
//		byte[] data = line.getBytes("UTF-8");//ת��Ϊ�ֽ�
//		fos.write(data);//д��
		osw.write(line);//����ת��Ϊ�ֽڣ�ʹ���ֽ�������ֱ��д���ַ�����������������һ��ת��Ϊ�ֽ���
		
		System.out.println("д�����");
//		fos.close();
		osw.close();
	}
}
