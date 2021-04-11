package Y2021M3D24_IO;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 	��ɼ��׼��±�����
 * 	����������Ҫ���û������ļ�����Ȼ��Ը��ļ�����д������
 * 	֮���û������ÿһ���ַ���������д�뵽���ļ��С�
 * 	����PWʱҪ��ʹ��������ģʽ
 * @author Grant��Vranes
 *
 */
public class PwTest {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���׼��±����������ļ���:");
		String fileName = scanner.nextLine();
		
		FileOutputStream fos = new FileOutputStream(fileName);
		OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		/*
		 * 	���������ӵ��д���PrintWriterʱ����ָ���ڶ����������ò���
		 * 	Ϊһ��booleanֵ�������ֵΪtrueʱ����ǰPW�����Զ���ˢ�¹���
		 * 	����ÿ������println����д��һ���ַ���ʱ�ͻ��Զ�flush������
		 * 	   ��ʵд��������һ����ʵд����Ƶ���ˣ�Ч�ʾͻ��½������ò��ÿ���ȡ
		 * 	   ����ʲô��������ǹ�ע��Ϣ�ļ�ʱ�ԣ���Ҫ�á�
		 * 	ע�⣺print�����ǲ����Զ�flush��
		 */
		PrintWriter pw = new PrintWriter(bw,true);
		
		System.out.println("---------Ins----------");
		String info = null;
		while(true) {
			info = scanner.nextLine();
			if("exit".equals(info)) {
				break;
			}
			pw.println(info);
			pw.flush();
		}
		System.out.println("�༭���");
		pw.close();
	}
}