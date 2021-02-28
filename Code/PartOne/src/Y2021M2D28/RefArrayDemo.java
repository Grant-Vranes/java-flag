package Y2021M2D28;
//引用类型数组的演示
public class RefArrayDemo {
	public static void main(String[] args) {
		Student[] stus = new Student[3];
		stus[0] = new Student("A",25,"A");
		stus[1] = new Student("B",25,"B");
		stus[2] = new Student("C",25,"C");
		System.out.println(stus[1].age);
		stus[2].sayHi();
		
		Student[] ss = new Student[] {
			new Student("A",25,"A"),
			new Student("B",25,"B"),
			new Student("C",25,"C")
		};
		
		int[][] arr = new int[3][4];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				arr[i][j] = (int)(Math.random()*100);
		    }
		}
	}
}
