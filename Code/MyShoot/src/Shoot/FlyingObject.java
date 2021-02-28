package Shoot;
//飞行物
public class FlyingObject {
	int width;
	int height;
	int x;
	int y;
	//关于speed不是所有成员共有的，英雄机没有。
	
	//飞行物移动
	void step() {
		System.out.println("飞行物移动");
	}
	
	//专门给小敌机、大敌机、小蜜蜂提供的
	FlyingObject(int width, int height){
		this.width = width;
		this.height = height;
		x = (int)(Math.random()*(400-this.width));//x：0到（窗口宽-小敌机宽）之间的随机数 
		/*也可以这么写
		 * Random rand = new Random();
		 * x = rand.nextInt(400-this.width);
		 */
		y = -this.height;//y:负的小敌机、大敌机、小蜜蜂的高度
	}
	
	//专门给英雄机、天空、子弹提供
	FlyingObject(int width, int height, int x, int y){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
}
