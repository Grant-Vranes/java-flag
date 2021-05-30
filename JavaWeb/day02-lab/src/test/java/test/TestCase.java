package test;

import java.sql.SQLException;

import util.DBUtils;

public class TestCase {
	public static void main(String[] args) throws SQLException {
		/**
		 * 测试能否获得链接
		 */
		System.out.println(DBUtils.getConn());
	}
}
