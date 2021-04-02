package Shoot;

import java.awt.image.BufferedImage;

/*大敌机*/
public class BigAirPlane extends FlyingObject implements Enemy{
	private static BufferedImage[] images;
	private static BufferedImage[] boms;
	static {
		images = new BufferedImage[2];
		for(int i=0; i<images.length; i++) {
			images[i] = loadImage("bigairplane"+i+".png");
		}
		//爆炸啊
		boms = new BufferedImage[4];
		for (int i = 0; i < boms.length; i++) {
			boms[i] = loadImage("bom"+i+".png");
		}	
	}
	private int speed;//移动速度
	
	/*构造方法*/
	public BigAirPlane() {
		super(66,89);
		speed = 2;//大敌机速度
		//System.out.println("大敌机出现了");
	}
	
	/*移动*/
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
	
	/*重写getScore()得分*/
	public int getScore() {
		return 3;//打掉大敌机，玩家得3分
	}
}
