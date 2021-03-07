<p align = center><font size = 9>LeetCode</font></p>

<p align = center>瀑力汽水</p>



---

[toc]

---



## 1.两数之和(简单)

链接：https://leetcode-cn.com/problems/two-sum

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会<u>对应一个答案</u>。但是，数组中同一个元素<u>不能使用两遍</u>。

你可以按任意顺序返回答案。

 ```java
示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    
示例 2：
    输入：nums = [3,2,4], target = 6
    输出：[1,2]
    
示例 3：
    输入：nums = [3,3], target = 6
    输出：[0,1]

提示：
    2 <= nums.length <= 103
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    只会存在一个有效答案
 ```

```java
public int[] twoSum(int[] nums, int target) {
        /*暴力破解法*/
        int len = nums.length;//避免每次进入for循环都会执行length方法
        for (int i = 0; i < len; i++) {//i只需要遍历到倒数第二个数，因为最后j=i+1会获取最后一个值，如果i遍历到倒数第一个数，就没有必要
            for (int j = i + 1; j < len; j++) {
                if (target == nums[i] + nums[j])
                    return new int[]{i,j};
            }
        }
        return new int[]{};
}
-------------------------------------------------------------------------
import java.util.HashMap;
import java.util.Map;

public int[] twoSum(int[] nums, int target){
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
```

<video src="LeetCode.assets/twosum_1.mp4"></video>