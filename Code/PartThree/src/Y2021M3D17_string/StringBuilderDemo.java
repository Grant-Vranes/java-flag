package Y2021M3D17_string;
/**
 * StringBuilder专门用来修改字符串内容的API，
 * String由于其优化设计导致的问题就是不能频繁修改(每次都创建新对象)
 * @author Grant·Vranes
 *
 */
public class StringBuilderDemo {
	public static void main(String[] args) {
		String str = "好好学习";
		
		//默认表示空字符串
		//StringBuilder builder = new StringBuilder();
		StringBuilder builder = new StringBuilder(str);
	
		/*
		 * append():拼接字符串
		 */
		builder.append("，天天向上");
		//StringBuilder的toString方法用来获取其内部表示的字符串内容
		str = builder.toString();
		System.out.println(str);//好好学习，天天向上
		
		/*
		 * replace():换掉指定位置内容,左闭右开
		 */
		builder.replace(5, 9, "改变世界");
		System.out.println(builder.toString());//好好学习，改变世界
		
		/*
		 * delete():删除字符串中指定位置的元素,左闭右开
		 */
		builder.delete(0, 5);
		System.out.println(builder.toString());//改变世界
		
		/*
		 * insert():插入
		 */
		builder.insert(0, "我");
		System.out.println(builder.toString());//我改变世界
	}
}
