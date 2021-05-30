package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserDao;
import entity.User;
import util.DBUtils;

public class TestCase {
	@Test
	public void getConn() throws SQLException {
		/**
		 * 测试能否获得链接
		 */
		System.out.println(DBUtils.getConn());
	
	}
	
	@Test
	public void testUserDao() {
		UserDao dao = new UserDao();
		List<User> users = dao.findAll();
		System.out.println(users);
	}
}
