package Y2021M3D17_string;
/**
 * 	和谐用语:将违禁内容替换为*
 * @author Grant·Vranes
 *
 */
public class ReplaceAllTestDemo {
	public static void main(String[] args) {
		String regex = "(wqnmlgdsb|mmp|nc|mdzz|cnm|djb)";
		String message = "wqnmlgdsb!你cnm";
		message = message.replaceAll(regex, "***");
		System.out.println(message);
		
	}
}
