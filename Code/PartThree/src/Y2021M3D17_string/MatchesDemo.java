package Y2021M3D17_string;
/**
 * String支持正则表达式方法之一：
 * boolean matches(String regex)
 * 用给定的正则表达式验证当前字符串是否符合其格式要求
 * @author Grant·Vranes
 *
 */
public class MatchesDemo {
	public static void main(String[] args) {
		String email = "fancq@tedu.cn";
		/*
		 *验证email格式的正则表达式
		 *\w+@\w+(\.[a-zA-Z]+)+ 
		 */
		String regex = "\\w+@\\w+(\\.[a-zA-Z]+)+";
		boolean match = email.matches(regex);
		/*
		 * 注意：matches方法指定的的正则表达式就算不指定边界匹配符，也是做全匹配验证的
		 */
		
		if(match) {
			System.out.println("是邮箱的正确格式");
		}else {
			System.out.println("不是邮箱的正确格式");
		}
	}
}
