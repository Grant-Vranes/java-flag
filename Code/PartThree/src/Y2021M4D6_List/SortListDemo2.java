package Y2021M4D6_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 	排序自定义类型元素
 * @author Grant·Vranes
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(3,4));
		list.add(new Point(5,6));
		list.add(new Point(3,8));
		list.add(new Point(2,7));
		System.out.println(list);
		/*
		 * 	Collections的sort方法排序的集合要求元素必须实现Comparable接口
		 * 	然后重写compareTo方法，在方法中定义比较的规则
		 * 
		 * 	如果是排序自定义类型元素，强烈建议不使用这种方式，因为这个sort方法对我
		 * 	们的代码有侵入性（它要求Point必须为它实现接口，并重写方法；改的越多侵入性就越强）
		 * 	由于java API中很多类已经实现了该接口，比如包装类，String等，那么在排序这样元素
		 * 	的集合时可以直接用 下面这个sort
		 */
		Collections.sort(list);
		System.out.println(list);
	}
}
