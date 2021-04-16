package 栈01;
import java.util.Arrays;
import java.util.Stack;
/**
 * 【题目】一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
 *
 * 输入：[5, 2]
 *
 * 输出：[1, -1]
 *
 * 解释：因为元素 5 的右边离我最近且比我小的位置应该是 A[1]，最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
 */
public class Demo4 {
    public static void main(String[] args) {
        int[] a = {1,2,4,9,4,0,5};
//        for (int c : d.findRightSmall(a)) {
//            System.out.print(c+",");
//        }
        System.out.println(Arrays.toString(findRightSmall(a)));
    }
    public static int[] findRightSmall(int[] A) {
        // 结果数组,与A的索引位置一一对应
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标
        Stack<Integer> t = new Stack();
        for (int i = 0; i < A.length; i++) {
            // 当前元素
            final int x = A[i];
            // t.peek()表示在栈顶存的【A数组元素的索引值】
            while (!t.empty() && A[t.peek()] > x) {
                // 其实ans数组存储的索引位置与A数组的索引对应的，如下第一次执行时[0,0,0,4,0,0]
                ans[t.peek()] = i;
                // 找到了右边第一个比我小的下标位置，然后就将我弹栈，我已经不需要再找了，在我前面的还在栈中的元素继续寻找
                t.pop();
            }
            // 剩下的入栈
            t.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!t.empty()) {
            ans[t.peek()] = -1;
            t.pop();
        }
        return ans;
    }
}
