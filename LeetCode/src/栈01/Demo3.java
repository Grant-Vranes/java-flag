package 栈01;

import java.util.Stack;

/**
 * 大鱼吃小鱼
 * 在水中有许多鱼，可以认为这些鱼停放在 x 轴上。
 * 再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。
 * 这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 * 	1)所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 * 	2)当方向相对时，大鱼会吃掉小鱼；
 *     3)鱼的大小都不一样。
 *
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
 * 输出：3
 *
 * 请问还剩下几条鱼？
 */
public class Demo3 {
    public static void main(String[] args) {
        Demo3 d = new Demo3();
        int[] Size = {4, 2, 5, 3, 1};
        int[] Dir = {1,1,0,0,0};
        System.out.println(d.solution(Size,Dir));
    }
    public int solution(int[] fishSize, int[] fishDirection){
        //首先拿到鱼的数量
        final int fishNumber = fishSize.length;
        //如果鱼的数量小于等于1，直接返回鱼的数量
        if(fishNumber <= 1){
            return fishNumber;
        }

        //0表示鱼向左游动,1表示向右游动
        final int left = 0;
        final int right = 1;

        //创建一个栈，用于存放鱼的索引
        Stack<Integer> t = new Stack();
        for (int i = 0; i < fishNumber; i++) {
            //获取当前遍历到的鱼的情况
            final int curFishSize = fishSize[i];
            final int curFishDeirction = fishDirection[i];
            //用hasEat变量当前鱼是否被吃掉
            boolean hasEat = false;
            //如果栈中还有鱼，并且栈中鱼向右，当前的鱼向左，那么就会有相遇的可能
            while(!t.empty() && fishDirection[t.peek()]==right && curFishDeirction==left){
                //如果栈顶的鱼比较大，那么就把新来的吃掉
                if(fishSize[t.peek()] > curFishSize){
                    hasEat = true;//新来的鱼被吃掉了
                    break;
                }
                //如果栈中的鱼较小，那么会把栈中的鱼吃掉，栈中的鱼被消除，所以需要弹栈
                t.pop();
            }
            //如果新来的鱼，没有被吃掉，那么压入栈中
            if(!hasEat){
                t.push(i);
            }
        }
        return t.size();//返回栈中的元素
    }
}
