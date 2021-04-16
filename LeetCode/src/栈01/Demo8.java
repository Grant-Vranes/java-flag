package 栈01;
import java.util.Stack;
import java.util.Arrays;

/**
 *  【题目】给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：
 *     1. 长度为 k
 *     2. 字典序最小
 *  输入：nums = [3,5,2,6], k = 2
 *  输出：[2,6]
 *
 *  特性：递增栈
 */
public class Demo8 {
    public static void main(String[] args) {
        int[] A = {1,2,4,9,4,0,5};
        System.out.println(Arrays.toString(findSmallSeq(A,3)));
    }
    public static int[] findSmallSeq(int[] nums, int k) {
         //最后输出的结果数组一定要在长度上满足length=k
         int[] ans = new int[k];
         // 这里生成单调栈
         Stack<Integer> s = new Stack();
         //遍历数组中元素
         for (int i = 0; i < nums.length; i++) {
              //获取当前遍历到的元素
              final int x = nums[i];
              //left指数组中未被遍历到的数的个数
              final int left = nums.length - i;
              // 注意我们想要提取出k个数，所以注意控制扔掉的数的个数
              //如果栈中的元素个数与未被遍历到的元素的个数之和大于k，为了避免弹栈最后出现结果集的个数不满足k的情况
              while (!s.empty() && (s.size() + left > k) && s.peek() > x) {
                 s.pop();
              }
              s.push(x);
         }
                // 如果递增栈里面的数太多，那么我们只需要取出前k个就可以了。
                // 多余的栈中的元素需要扔掉。
         while (s.size() > k) {
            s.pop();
         }
         // 把k个元素取出来，注意这里取的顺序!
        // 因为栈的特性是先进后出，而结果集ans与栈的大小和位置都是对应的
         for (int i = k - 1; i >= 0; i--) {
              ans[i] = s.peek();
              s.pop();
         }
         return ans;
    }
}
