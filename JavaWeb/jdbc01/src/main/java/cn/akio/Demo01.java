package cn.akio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 	连接数据库
 * @author Grant·Vranes
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
		//3.创建SQL执行对象
		Statement stat = conn.createStatement();
		//4.执行SQL
		String sql = "create table jdbc(id int, name varchar(10))";
		stat.execute(sql);
		System.out.println("创建完成");
		//5.关闭资源
		stat.close();
		conn.close();
	}
}
