package Y2021M3D21_raf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * RAF��ר��������д�ļ����ݵ�API�������ָ����ļ�
 * 	���ݽ��ж�д�������������ı༭�ļ��������ݡ�
 * 	����RAFʱ����ָ���Ը��ļ���Ȩ�ޣ����õ������֣�
 * r:ֻ��ģʽ
 * rw:��дģʽ
 * @author Grant��Vranes
 *
 */
public class RafDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 	�Ե�ǰĿ¼�е�raf.dat�ļ���д
		 * RAF֧�����ֳ��ù��췽����
		 * RandomAccessFile(File file, String mode)
		 * RandomAccessFile(String path, String mode)
		 * 	ע�����·����"./"�ǿ��Ժ��Բ�д�ģ���ΪĬ�Ͼ��Ǵӵ�ǰĿ¼��ʼ
		 * 
		 * RAF����ʱ����дȨ�޵�����£���ָ���ļ�������ʱ���Զ����䴴������
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		
		/*
		 * void write(int d)
		 * 	���ļ���д��1�ֽڣ�д���Ǹ�����intֵ��Ӧ��2���Ƶġ��Ͱ�λ��
		 * 							  vvvvvvvv
		 * 00000000 00000000 00000000 00000000
		 */
		raf.write(1);
		System.out.println("д�����");
		raf.close();//�ͷ���Դ
	}
}