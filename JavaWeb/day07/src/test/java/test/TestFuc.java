package test;

import org.junit.Test;

import dao.UserDao;
import entity.User;

public class TestFuc {
	@Test
	public void test1() {
		UserDao dao = new UserDao();
		User user = dao.findByUsername("123");
		System.out.println(user);
	}
}
