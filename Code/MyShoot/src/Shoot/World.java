package Shoot;
/*������Ϸ����*/
public class World {
	Sky sky;
	Hero hero;
	AirPlane[] as;
	BigAirPlane[] bas;
	Bee[] bs;
	Bullet[] bts;
	
	void action() {//���Դ���
		//Sky sky = new Sky();//������������ֻ����������ã����������ò��ˣ�����д����Χ
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