package Y2021M3D17_string;
/**
 * String replaceAll(String regex, String str)
 * 将当前字符串中符合正则表达式要求的部分替换为给定内容
 * @author Grant·Vranes
 *
 */
public class ReplaceAllDemo {
	public static void main(String[] args) {
		String str = "abc123def456ghi789jkl";
		/*
		 * 	将数字部分替换为"#NUM#"
		 */
		String regex = "[0-9]+";
		str = str.replaceAll(regex, "#NUM#");
		System.out.println(str);
	}
}
