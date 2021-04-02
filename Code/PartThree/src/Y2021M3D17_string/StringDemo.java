package Y2021M3D17_string;
/**
 *	String�ǲ������JVM��������һ���Ż������ڴ��п�����һ������
 *	 ��Ϊ�����أ�����ͨ��������������ʽ�������ַ������󶼻Ỻ�沢���á�
 *	 ��Ϊ���ö������Ըö������ݲ��ɱ�
 * @author Grant��Vranes
 *
 */
public class StringDemo {
	public static void main(String[] args) {
		String s1 = "123abc";//��������ʽ����������new������
		String s2 = "123abc";//s1����s1�������ַ�������
		System.out.println(s1==s2);//true
		
		//�޸����ݻᴴ���������¶���
		s1 = s1+"!";
		System.out.println("s1:"+s1);//123abc!
		System.out.println("s2:"+s1);//123abc	������Ӱ��
	
		//newһ�������¶���
		String s4 = new String("123abc");
		System.out.println(s2==s4);//false

		/*
		 *	��������һ���Ż���ʩ��������Դ����ʱ����һ��������ʽ
		 *	���в�������������ʱ(�Ǳ���),��ֱ�ӽ��м��㣬���������
		 *	�뵽class�ļ��С����ԣ����������class�ļ���Ϊ
		 *	String s5 = "123abc";
		 */
		String s5 = "123" + "abc";
		System.out.println(s2==s5);//true
		
		/*
		 *������ʽһ��Ϊ��������ô���������ڼ�ƾ�裬��ô�ᴴ���¶���
		 */
		String s = "123";
		String s6 = s + "abc";
		System.out.println(s2==s6);//false
	}
}
