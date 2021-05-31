package bean;
/**
 * 满足条件，是一个bean
 * @author Grant·Vranes
 *
 */
public class User {
	private String username;
	private int age;
	private String[] love;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getLove() {
		return love;
	}
	public void setLove(String[] love) {
		this.love = love;
	}
}
