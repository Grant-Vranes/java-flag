package Y2021M3D17_string;
/**
 * char charAt(int index)
 * ���ڷ����ַ���ָ��λ�õ��ַ�������index��ʾָ����λ��
 * @author Grant��Vranes
 *
 */
public class CharAtDemo {
	public static void main(String[] args) {
		String str = "thinking in java";
		System.out.println(str.charAt(9));//i
	
		/*
		 *	�жϻ���
		 *	�Ϻ�����ˮ���Ժ��� 
		 */
		str = "�Ϻ�����ˮ���Ժ���";
		int i;
		for (i = 0; i < str.length()/2; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(str.length()-1-i);
			if(c1 != c2) {
				System.out.println("���ǻ���");
				break;
				//return;//��������
			}
		}
		if(i == str.length()/2) {//�����嶼������
			System.out.println("�ǻ���");
		}
	}
}
