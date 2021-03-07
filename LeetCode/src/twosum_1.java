import java.util.HashMap;
import java.util.Map;
public class twosum_1 {
    public static void main(String[] args) {
        int[] nums = {3,8,7,2,9};
        twosum_1 t = new twosum_1();
        for(int v : t.twoSum(nums,9)){
            System.out.print(v+" ");
        }
    }


    public int[] twoSum(int[] nums, int target) {
        /**暴力破解法
        int len = nums.length;//避免每次进入for循环都会执行length方法
        for (int i = 0; i < len; i++) {//i只需要遍历到倒数第二个数，因为最后j=i+1会获取最后一个值，如果i遍历到倒数第一个数，就没有必要
            for (int j = i + 1; j < len; j++) {
                if (target == nums[i] + nums[j])
                    return new int[]{i,j};
            }
        }
        return new int[]{};
        */

        /**哈希表法:内存换时间*/
        int len = nums.length;
        Map<Integer,Integer> hashMap = new HashMap<>(len-1);//使用hash表尽量指定大小，以避免hash表扩容所带来的性能消耗
        hashMap.put(nums[0],0);//第一个元素必然存入hash表
        for (int i = 1; i < len; i++) {
            int another = target-nums[i];
            if(hashMap.containsKey(another)){
                return new int[]{i,hashMap.get(another)};
            }
            hashMap.put(nums[i],i);//将数据存入hash表
        }
        //return new int[]{};
        throw new IllegalArgumentException("No two sum solution");
    }
}
