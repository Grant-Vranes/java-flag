package 栈01;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2.数组中元素左边离我最近且比我小的元素的位置
 * 输入[1, 2, 4, 9, 4, 0, 5]
 * 输出[-1, 0, 1, 2, 1, -1, 5]
 */
public class Demo6 {
    public static void main(String[] args) {
        int[] A = {1,2,4,9,4,0,5};
        System.out.println(Arrays.toString(findLeftSmall(A)));
    }
    public static int[] findLeftSmall(int[] A){
        //结果集
        int[] ans = new int[A.length];
        Stack<Integer> t = new Stack();
        //遍历数组
        for (int i = A.length-1; i >=0 ; i--) {
            final int x = A[i];//获取当前元素
            while(!t.empty() && A[t.peek()] > x){
                ans[t.peek()] = i;
                t.pop();
            }
            t.push(i);
        }
        while(!t.empty()){
            ans[t.peek()] = -1;
            t.pop();
        }


        return ans;
    }

}
