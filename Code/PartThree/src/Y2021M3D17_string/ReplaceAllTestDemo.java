package Y2021M3D17_string;
/**
 * 	��г����:��Υ�������滻Ϊ*
 * @author Grant��Vranes
 *
 */
public class ReplaceAllTestDemo {
	public static void main(String[] args) {
		String regex = "(wqnmlgdsb|mmp|nc|mdzz|cnm|djb)";
		String message = "wqnmlgdsb!��cnm";
		message = message.replaceAll(regex, "***");
		System.out.println(message);
		
	}
}
