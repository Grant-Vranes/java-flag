package Y2021M3D24_IO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 	����������ʹ��PW
 * @author Grant��Vranes
 *
 */
public class PwDemo2 {
	public static void main(String[] args) throws IOException {
		//�����Ǹ�������д���ļ��Ĳ���
		//���ֽ�д���ļ�
		FileOutputStream fos = new FileOutputStream("pw.txt");
		//���ַ�ת���ֽ�,֧��ָ���ַ���
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		//��д
		BufferedWriter bw = new BufferedWriter(osw);
		//�Զ���ˢ��
		PrintWriter pw = new PrintWriter(bw);
		
		pw.println("һ���˵�ҹ���ҵ��ģ�˫��Ӧ�÷�������~");
		System.out.println("д�����");
		
		pw.close();//�����Ѱ���flush����
	}
}
