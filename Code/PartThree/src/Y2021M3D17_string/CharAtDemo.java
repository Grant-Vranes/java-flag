package Y2021M3D17_string;
/**
 * char charAt(int index)
 * 用于返回字符串指定位置的字符，参数index表示指定的位置
 * @author Grant·Vranes
 *
 */
public class CharAtDemo {
	public static void main(String[] args) {
		String str = "thinking in java";
		System.out.println(str.charAt(9));//i
	
		/*
		 *	判断回文
		 *	上海自来水来自海上 
		 */
		str = "上海自来水来自海上";
		int i;
		for (i = 0; i < str.length()/2; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(str.length()-1-i);
			if(c1 != c2) {
				System.out.println("不是回文");
				break;
				//return;//结束方法
			}
		}
		if(i == str.length()/2) {//当整体都走完了
			System.out.println("是回文");
		}
	}
}
