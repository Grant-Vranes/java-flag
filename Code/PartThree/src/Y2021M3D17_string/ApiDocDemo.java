package Y2021M3D17_string;
/**
 * 	文档注释只在三个地方使用
 *	类、方法、常量
 *	文档注释是功能级注释，用来说明类，方法或常量的设计意图及功能描述
 *	文档注释最终可以被javadoc命令成为手册
 * @author Grant·Vranes
 * @version 1.0 整数部分表示真正的版本更新（功能改变），小数点表示小版本号，只是修饰bug，本身功能没有什么改变
 * @see java.lang.String 参考的类
 * @since JDK1.0 程序最低运行版本
 */
public class ApiDocDemo {
	/**
	 * 	常量注释：
	 * 	INFO代表常量“你好”
	 */
	public static final String INFO = "你好";
	
	/**
	 * 	方法注释：用于解释这个方法的设计意图
	 * 	设计意图：
	 * 	为给定的用户添加问候语	
	 * @param name 要添加问候语的用户名的名字
	 * @return	返回含有问候语的字符串
	 */
	public String sayHello(String name) {
		String s = "";
		return INFO+name;
	}
}
