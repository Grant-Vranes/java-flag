package Shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Timer;//定时器
import java.util.TimerTask;//定时任务
import java.util.Random;
import java.util.Arrays;
import java.awt.event.MouseAdapter;//侦听器
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/*整个游戏世界*/
public class World extends JPanel{
	public static final int WIDTH = 400;//窗口的宽设置为常量
	public static final int HEIGHT = 700;
	
	public static final int START = 0;//启动状态
	public static final int RUNNING = 1;//运行状态
	public static final int PAUSE = 2;//暂停状态
	public static final int GAME_OVER = 3;//游戏状态
	private int state = START;//当前状态默认为启动状态
	
	private static BufferedImage start;//启动图
	private static BufferedImage pause;//暂停图
	private static BufferedImage gameover;//游戏结束图，运行状态不需要
	static {//初始化静态资源
		start = FlyingObject.loadImage("start.png");
		pause = FlyingObject.loadImage("pause.png");
		gameover = FlyingObject.loadImage("gameover.png");
	}
	
	private Sky sky = new Sky();
	private Hero hero = new Hero();
	//将所有敌人数组合为超类数组
	//private FlyingObject[] enemies = new FlyingObject[0];//使用向上造型，统含所以敌人：小敌机、大敌机、小蜜蜂
	private FlyingObject[] enemies = {};//与上一条等价
	private Bullet[] bullets = {};
	
	/*生成敌人（小敌机、大敌机、小蜜蜂）*/
	public FlyingObject nextOne(){
		Random rand = new Random();
	    int type = rand.nextInt(20);//0到19
	    if(type<2){//0~1  使用概率的分散来控制创建各类对象的频率
			return new Bee();
	    }else if(type<15){//2~14
	        return new AirPlane();
	    }else{//12~19
			return new BigAirPlane();
	    }
	}
	
	int enterIndex = 0;//敌人的入场计数
	/*敌人（小敌机、大敌机、小蜜蜂）入场*/
	public void enterAction() {//每10ms走一次
		enterIndex++;//每10ms增1
		if(enterIndex%40==0) {//每40*10ms走一次，为了控制敌人出场的频率
			FlyingObject obj = nextOne();
			enemies = Arrays.copyOf(enemies, enemies.length+1);//数组扩容
			enemies[enemies.length-1] = obj;//将敌人添加到enemies最后一个元素上
			
		}
	}
	
	int shootIndex = 0;
	/*子弹入场*/
	public void shootAction() {//每10ms走一次
		shootIndex++;
		if(shootIndex%30 == 0) {//每30*10ms走一次，为了控制子弹出场的频率
			Bullet[] bs = hero.shoot();//获取子弹对象
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);//扩容（bs有几个元素就能扩大几个容量）
			//数组的追加
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	
	/*飞行物移动*/
	public void stepAction() {//每10ms走一次
		sky.step();
		for(int i=0; i<enemies.length; i++) {
			enemies[i].step();
		}
		for(int i=0; i<bullets.length; i++) {
			bullets[i].step();
		}
		
	}
	
	/*删除越界的敌人和子弹*/
	public void outOfBoundsAction() {//每10ms走一次
		int index = 0;//1）下标 2）计数器，记不越界敌人个数
		FlyingObject[] enemyLives = new FlyingObject[enemies.length];//装着所有不越界的敌人，因为在一开始所有敌人都没有越界
		for(int i=0; i<enemies.length; i++){
		    FlyingObject f = enemies[i];
		    if(!f.outOfBounds() && !f.isRemove()){//不越界，并且非REMOVE
		    	enemyLives[index] = f;//如果敌人不越界就将它装到不越界的数组enemyLives中，最后缩容截掉越界的敌人（即没有出现在这个数组中的敌人）
		           	index++;
		    }
		}
		enemies = Arrays.copyOf(enemyLives,index);//缩容保留不越界的敌人
		
		//清除越界子弹
		index = 0;
	    Bullet[] bulletLives = new Bullet[bullets.length];
	    for (int j = 0; j < bullets.length; j++) {
			Bullet b = bullets[j];
			if(!b.outOfBounds() && !b.isRemove()) {
				bulletLives[index] = b;
				index++;
			}
		}
	    bullets = Arrays.copyOf(bulletLives, index);   
	}
	
	int score=0;//玩家得分
	/*子弹和敌人的碰撞*/
	public void bulletBangAction() {//每10ms走一次
		for(int i=0; i<bullets.length;i++) {//遍历所有子弹
			Bullet b = bullets[i];//获取每一个子弹
			for(int j=0; j<enemies.length; j++) {//遍历所有敌人
				FlyingObject f = enemies[j];//获取每一个敌人
				if(b.isLife() && f.isLife() && f.hit(b)) {//撞上了
					b.goDead();//子弹死
					f.goDead();//敌人死
					/*判断敌人类型用于加分:复用性差，扩展性差，维护性差
					if(f instanceof AirPlane) {
						AirPlane a = (AirPlane)f;
						score += a.getScore();
					}
					if(f instanceof AirPlane) {
						BigAirPlane ba = (BigAirPlane)f;
						score += ba.getScore();
					}
					if(f instanceof AirPlane) {
						Bee bee = (Bee)f;
						int type = bee.getAwardType();
						switch(type) {
						case Award.DOUBLE_FIRE:
							hero.addDoubleFire();
							break;
						case Award.LIFE:
							hero.addLife();
							break;
						}
					}
					*/
					//扩展性好，维护性好，复用性好
					if(f instanceof Enemy) {//若被撞敌人能得分
						Enemy e = (Enemy)f;//则强转为得分接口
						score += e.getScore();//玩家得分
					}
					if(f instanceof Award) {//若被撞第人为奖励（小蜜蜂）
						Award a = (Award)f;//则强转为奖励接口
						int type = a.getAwardType();
						switch(type) {
							case Award.DOUBLE_FIRE:
								hero.addDoubleFire();
								break;
							case Award.LIFE:
								hero.addLife();
								break;
						}
					}
				}
			}	
		}
	}
	
	/*英雄机与敌人碰撞*/
	public void heroBangAction() {//每10ms走一次
		for (int i = 0; i < enemies.length; i++) {//遍历每个敌人
			FlyingObject f = enemies[i];//获取每个敌人
			if(hero.isLife() && f.isLife() && f.hit(hero)) {//如果英雄机活着，并且敌人活着，并且敌人装上英雄机
				f.goDead();//敌人去死
				hero.subtractLife();//英雄机减命
				hero.clearDoubleFire();//英雄机清空火力
			}
		}
	}
	
	/*检测游戏结束*/
	public void checkGameOverAction(){//每10ms走一次
		if(hero.getLife() <= 0) {//游戏结束了
			state = GAME_OVER;//当前状态修改为游戏状态
		}
		
	}
	/*启动程序的执行*/
	public void action() {
		MouseAdapter l = new MouseAdapter() {//匿名内部类
			/*重写mouseMoved鼠标移动*/
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING) {
					int x = e.getX();//获取鼠标的x坐标
					int y = e.getY();//获取鼠标的y坐标
					hero.moveTo(x, y);
				}
			}
			/*重写鼠标点击*/
			public void mouseClicked(MouseEvent e) {
				switch(state) {//根据当前状态做不同的处理
				case START:			//启动状态时，点击
					state = RUNNING;//修改为运行状态
					break;
				case GAME_OVER:		//游戏结束状态时，点击
					score = 0;		//清理现场，所有东西归零
					sky = new Sky();
					hero = new Hero();
					enemies = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;	//修改为启动状态
					break;
				}
			}
			/*重写mouseExited鼠标移出*/
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING  ) {//运行状态时，移出
					state = PAUSE;	  //修改为暂停状态
				}
			}
			/*重写mouseExited鼠标移入*/
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE) {//暂停状态时，
					state = RUNNING;//修改为运行状态
				}
			}
		};
		this.addMouseListener(l);//处理鼠标操作事件
		this.addMouseMotionListener(l);//处理鼠标滑动事件
		
		Timer timer = new Timer();
		int intervel = 10;//以毫秒为单位
		timer.schedule(new TimerTask() {
			public void run() {//定时干的事
				if(state == RUNNING) {
					enterAction();//敌人（小敌机、大敌机、小蜜蜂）入场
					shootAction();//子弹入场（英雄机发射子弹）
					stepAction();//实现飞行物移动
					outOfBoundsAction();//删除越界的敌人和子弹
					//System.out.println(enemies.length+" "+bullets.length);
					bulletBangAction();//子弹撞击
					heroBangAction();//英雄机与敌人的碰撞
					checkGameOverAction();//检测游戏结束
				}
				repaint();//重画（调用paint()）
			}
		}, intervel, intervel);

	}
	
	/*重写超类中的paint()*/
	public void paint(Graphics g) {
		sky.paintObject(g);//画天空
		hero.paintObject(g);//画英雄机
		for(int i=0; i<enemies.length; i++) {
			enemies[i].paintObject(g);//画敌人
		}
		for(int i=0; i<bullets.length; i++) {
			bullets[i].paintObject(g);//画子弹
		}
		
		//画分和画命
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("LIFE:"+hero.getLife(),10,45);
	
		//在不同的状态下画不同的图
		switch(state) {
		case START:
			g.drawImage(start,0,0,null);
			break;
		case PAUSE:
			g.drawImage(pause,0,0,null);
			break;
		case GAME_OVER:
			g.drawImage(gameover,0,0,null);
			break;
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		World world = new World();
		frame.add(world);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);//效果:1)设置可见性2)调用paint()方法
		
		world.action();//启动程序的执行
	}

}
