package Y2021M3D24_IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * java.io.PrintWriter
 * 	�����Զ���ˢ�µĻ����ַ������
 * 	�����бȽϳ��õ��ַ��߼���
 * 
 * 	���԰���д���ַ���
 * @author Grant��Vranes
 *
 */
public class PwDemo1 {
	public static void main(String[] args) throws IOException, UnsupportedEncodingException {
		/*
		 *	PW�ṩ��ר�����д�ļ��Ĺ��췽��
		 *	PrintWriter(String path)
		 *	PrintWriter(File file)
		 */
		PrintWriter pw = new PrintWriter("pw.txt","UTF-8");
		/*�鿴Դ�룬ʵ����PrintWriterҲ������FileOutputStream,
		 * OutputStreamWriter,BufferedWriter��������
		 * 
		 * 	�����ָ���ַ����Ĳ���Ҳ�Ǹ�OutputStreamWriter����ģ���
		 * 	Ϊ��������ת���ֽں��ַ��ģ���Ҫ������������û�о���Ĭ���ַ�����
		 */
		
		pw.println("�ҵİ��εε��~");
		pw.println("ԲԲȦȦԶԶ~");
		
		System.out.println("д�����");
		pw.close();
	}
}
