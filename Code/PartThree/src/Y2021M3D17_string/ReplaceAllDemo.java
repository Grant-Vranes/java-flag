package Y2021M3D17_string;
/**
 * String replaceAll(String regex, String str)
 * ����ǰ�ַ����з���������ʽҪ��Ĳ����滻Ϊ��������
 * @author Grant��Vranes
 *
 */
public class ReplaceAllDemo {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jkl";
		/*
		 * 	�����ֲ����滻Ϊ"#NUM#"
		 */
		String regex = "[0-9]+";
		str = str.replaceAll(regex, "#NUM#");
		System.out.println(str);
	}
}
