package Y2021M3D17_string;
/**
 * String֧��������ʽ����֮һ��
 * boolean matches(String regex)
 * �ø�����������ʽ��֤��ǰ�ַ����Ƿ�������ʽҪ��
 * @author Grant��Vranes
 *
 */
public class MatchesDemo {
	public static void main(String[] args) {
		String email = "fancq@tedu.cn";
		/*
		 *��֤email��ʽ��������ʽ
		 *\w+@\w+(\.[a-zA-Z]+)+ 
		 */
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean match = email.matches(regex);
		/*
		 * ע�⣺matches����ָ���ĵ�������ʽ���㲻ָ���߽�ƥ�����Ҳ����ȫƥ����֤��
		 */
		
		if(match) {
			System.out.println("���������ȷ��ʽ");
		}else {
			System.out.println("�����������ȷ��ʽ");
		}
	}
}
