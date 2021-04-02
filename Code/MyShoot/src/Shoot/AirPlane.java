package Shoot;

import java.awt.image.BufferedImage;

/*小敌机*/
public class AirPlane extends FlyingObject implements Enemy{
	private static BufferedImage[] images;
	private static BufferedImage[] boms;
	static {
		images = new BufferedImage[2];
		for(int i=0; i<images.length; i++) {
			images[i] = loadImage("airplane"+i+".png");
		} 
		//爆炸啊
		boms = new BufferedImage[4];
		for (int i = 0; i < boms.length; i++) {
			boms[i] = loadImage("bom"+i+".png");
		}		
	}
	private int speed;//移动速度
	
	/*构造方法*/
	public AirPlane(){
		/*
		width = 48;
		height = 50;
		x = (int)(Math.random()*(400-this.width));//x：0到（窗口宽-小敌机宽）之间的随机数 
		/*也可以这么写
		 * Random rand = new Random();
		 * x = rand.nextInt(400-this.width);
		 *
		y = -this.height;//y:负的小敌机的高度
		*/
		super(48,50);
		//System.out.println("小敌机出现了");
		speed = 2;//小敌机速度
	}
	/*重写step()*/
	public void step() {
		y += speed;//(向下)
	}
	
	int index = 0;//下标
	/*重写getImage()*/
	public BufferedImage getImage() {
		if(isLife()) {
			return images[0];
		}else if(isDead()){
			BufferedImage bom = boms[index++];
			if(index == boms.length) {//当爆炸完就该消失了
				state = REMOVE;
			}
			return bom;
		}
		return null;
	}
	
	/*得分*/
	public int getScore() {
		return 1;
	}
}
