package test;

import java.util.List;

import org.junit.Test;

import dao.UserDao;
import entity.User;

public class TestClass {
	@Test
	public void test() {
		UserDao dao = new UserDao();
		List<User> users = dao.findAll();
		System.out.println(users);
	}
}
