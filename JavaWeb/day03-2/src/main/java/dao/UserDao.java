package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDao {
	/**
	 * 查询出所有用户的信息。
	 * 注：
	 * 关系数据库里面存放的是一条条记录，而java是面向对象的语言。
	 * 在设计DAO时，我们经常将查询到的记录转换成一个对应的java对象。
	 * @return
	 */
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_user";
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn, psta, rs);
		}
		return users;
	}
}
