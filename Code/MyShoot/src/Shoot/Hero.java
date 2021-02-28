package Shoot;

public class Hero extends FlyingObject{
		// 成员变量
		int life;//生命
		int doubleFire;//火力值
		//构造方法
		Hero(){
			/*
			//this指的是派生类
			//super指的是超类
			super.width = 97;//用this也可以
			super.height = 124;
			super.x = 140;
			super.y = 400;
			*/
			super(97,124,140,400);
			this.life = 3;
			this.doubleFire = 0;
		}
		// 英雄机切换图片
		void step() {
			x = 140;//英雄机初始位置
			y = 140;
			life = 3;
			doubleFire = 0;//单倍火力
		}
		
		//英雄机随鼠标移动，x/y鼠标的坐标
		void moveTo(int x,int y) {
			
		}
}
