public class 柱状图中最大的矩形_84 {
    public static void main(String[] args){
        int[] arr = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));//10
    }
    //暴力破解，leetcode会超时
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int ans = 0;
        //枚举高
        for (int mid = 0; mid < len; mid++) {
            int high = heights[mid];
            int left = mid, right = mid;
            //确定左边界，如果左边界存在，并且左边界的高度大于等于当前high，向左扩张
            while(left-1 >= 0 && heights[left-1] >= high){
                left--;
            }
            //确定右边界，如果有边界存在，并且右边界的高度大于等于当前high，向右扩张
            while(right+1 < len && heights[right+1] >= high){
                right++;
            }
            //计算面积，比较最大值，并将最大值赋给ans
            ans = Math.max(ans,(right-left+1)*high);
        }
        return ans;
    }
}
