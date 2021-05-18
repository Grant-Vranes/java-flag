package com.webserver.servlets;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 	����ע��ҵ��
 * @author Grant��Vranes
 *
 */
public class RegServlet {
	public void service(HttpRequest request, HttpResponse response) {
		/*
		 * 	ע���������:
		 * 	1:��ȡ�û��ύ��ע����Ϣ
		 * 	2����ע����Ϣд���ļ�user.dat
		 * 	3:��Ӧ�ͻ���ע��ɹ���ҳ��
		 */
		System.out.println("��ʼ����ע��ҵ�񣡣���");
		/*
		 * 	1
		 * 	ͨ��request.getParameter()������ȡ�û��ύ����������ʱ�����ݵĲ���
		 * 	����ַ�����ֵӦ����ҳ����form�����Ӧ������������(name���Ե�ֵ)
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("ע��ҵ����Ϣ:"+username+password+nickname+age);//��׮����
		
		/*
		 *  2
		 *  ÿ����¼ռ100�ֽڣ������û��������룬�����Ϊ�ַ�������ռ32�ֽڡ�
		 *  ����Ϊintֵռ4�ֽڡ�д�뵽user.dat�ļ���
		 */
		try {
			RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
			/*	ÿ��ִ�г����ʱ�򣨾���ÿд��һ�����ݼ�¼��ʱ�򣩣�ָ�붼�ڿ�ͷ����
			 * 	���ÿдһ��֮ǰд�ľͻᱻ���ǡ�����ÿһ�ε��ó����ض�ָ���λ�ã�ʹ
			 * 	�����ĩβ,���ź���д
			 */
			raf.seek(raf.length());
			
			//д�û���
			//1�Ƚ��û���ת�ɶ�Ӧ��һ���ֽ�
			byte[] data = username.getBytes("UTF-8");
			//2������������Ϊ32�ֽڣ������û�����󣬶����ݳ�32�ֽڣ�Ϊ��ȷ����������������100�ֽ�
			data = Arrays.copyOf(data, 32);
			//3�����ֽ�����һ����д���ļ�
			raf.write(data);
			
			//д���룬data���¸�ֵ
			data = password.getBytes("UTF-8");
			data = Arrays.copyOf(data,32);
			raf.write(data);
			
			//д�ǳ�
			data = nickname.getBytes("UTF-8");
			data = Arrays.copyOf(data,32);
			raf.write(data);
			
			//д����
			raf.writeInt(age);
			System.out.println("ע�����");
			
			//3��Ӧ�ͻ���ע��ɹ�ҳ��
			response.setEntity(new File("webapps/myweb/reg_success.html"));
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
