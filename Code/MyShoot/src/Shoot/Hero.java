package Shoot;
import java.awt.image.BufferedImage;

/*英雄机类*/
public class Hero extends FlyingObject{
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[2];
		images[0] = loadImage("hero0.png");
		images[1] = loadImage("hero1.png");
	}
	// 成员变量
	private int life;//生命
	private int doubleFire;//火力值
	
	/*构造方法*/
	public Hero(){
		/*
		this指的是派生类
		super指的是超类
		super.width = 97;//用this也可以
		super.height = 124;
		super.x = 140;
		super.y = 400;
		*/
		super(97,139,140,400);
		this.life = 3;
		this.doubleFire = 0;
	}
	
	/* 英雄机初始化*/
	public void step() {
		
	}
	
	/*英雄机随鼠标移动，x/y鼠标的坐标*/
	public void moveTo(int x,int y) {
		this.x = x-this.width/2;//英雄机的x=鼠标的x-1/2英雄机的宽;英雄机的(x,y)代表英雄机图片的左上角
		this.y = y-this.height/2;//英雄机的y=鼠标的y-1/2英雄机的高
	}
	
	int index = 0;//下标
	/*重写getImage()*/
	public BufferedImage getImage() {
		if(isLife()) {
			return images[index++%images.length];//在两张图片间来回切换
		}
		return null;
	}
	
	/*英雄机发射子弹（生成子弹）*/
	public Bullet[] shoot() {
		int xStep = this.width/4;//1/4英雄机的宽
		int yStep = 20;//固定的值（子弹的长度）
		if(doubleFire > 0) {//双倍火力：子弹位于飞机前方两侧
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x+1*xStep,y-yStep);//x:英雄机的x+1/4英雄机的宽  y:英雄机的y-固定的值
			bs[1] = new Bullet(this.x+3*xStep,y-yStep);//x:英雄机的x+3/4英雄机的宽  y:英雄机的y-固定的值
			doubleFire -= 2;//发射一次.双倍火力-2
			return bs;
		}else {//单倍火力：子弹位于飞机前方中间
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x+2*xStep,y-yStep);//x:英雄机的x+1/4英雄机的宽  y:英雄机的y-固定的值
			return bs;
		}
	}
}
