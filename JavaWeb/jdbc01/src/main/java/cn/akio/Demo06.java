package cn.akio;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池的等待问题
 * @author Grant·Vranes
 *
 */
public class Demo06 {
	public static void main(String[] args) throws SQLException {
		Connection c1 = DBUtils.getConn();
		System.out.println("获取到连接1:"+c1);
		Connection c2 = DBUtils.getConn();
		System.out.println("获取到连接2:"+c2);
		Connection c3 = DBUtils.getConn();
		System.out.println("获取到连接3:"+c3);
		//归还连接，并非断开连接
		c1.close();
		Connection c4 = DBUtils.getConn();
		System.out.println("获取到连接4:"+c4);
		
	}
}
