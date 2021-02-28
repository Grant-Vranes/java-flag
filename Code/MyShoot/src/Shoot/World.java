package Shoot;
/*整个游戏世界*/
public class World {
	Sky sky;
	Hero hero;
	AirPlane[] as;
	BigAirPlane[] bas;
	Bee[] bs;
	Bullet[] bts;
	
	void action() {//测试代码
		//Sky sky = new Sky();//如果声明在这就只能这个方法用，其他方法用不了，所以写在外围
		sky = new Sky();
		
		hero = new Hero();
		
		as = new AirPlane[3];
		as[0] = new AirPlane();
		as[1] = new AirPlane();
		as[2] = new AirPlane();
		for(int i = 0; i < as.length; i++) {
			System.out.println(as[i].x + ","+as[i].y);
			as[i].step();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World world = new World();
		world.action();
	}

}
