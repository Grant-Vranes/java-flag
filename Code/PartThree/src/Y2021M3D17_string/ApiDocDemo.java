package Y2021M3D17_string;
/**
 * 	�ĵ�ע��ֻ�������ط�ʹ��
 *	�ࡢ����������
 *	�ĵ�ע���ǹ��ܼ�ע�ͣ�����˵���࣬���������������ͼ����������
 *	�ĵ�ע�����տ��Ա�javadoc�����Ϊ�ֲ�
 * @author Grant��Vranes
 * @version 1.0 �������ֱ�ʾ�����İ汾���£����ܸı䣩��С�����ʾС�汾�ţ�ֻ������bug��������û��ʲô�ı�
 * @see java.lang.String �ο�����
 * @since JDK1.0 ����������а汾
 */
public class ApiDocDemo {
	/**
	 * 	����ע�ͣ�
	 * 	INFO����������á�
	 */
	public static final String INFO = "���";
	
	/**
	 * 	����ע�ͣ����ڽ�����������������ͼ
	 * 	�����ͼ��
	 * 	Ϊ�������û�����ʺ���	
	 * @param name Ҫ����ʺ�����û���������
	 * @return	���غ����ʺ�����ַ���
	 */
	public String sayHello(String name) {
		String s = "";
		return INFO+name;
	}
}
