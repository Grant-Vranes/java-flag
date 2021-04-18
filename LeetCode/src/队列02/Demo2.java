package 队列02;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  author：Akio
 */
public class Demo2 {
    //解法二
    // 二叉树结点的定义
    public class TreeNode {
        // 树结点中的元素值
        int val = 0;//当前元素的值
        // 二叉树结点的左子结点
        TreeNode left = null;
        // 二叉树结点的右子结点
        TreeNode right = null;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集
        List<List<Integer>> ans = new ArrayList<>();
        // 初始化当前层结点
        List<TreeNode> curLevel = new ArrayList<>();
        // 注意：需要root这个二叉树不为空的时候才加到里面。
        if (root != null) {
            curLevel.add(root);
        }
        while (curLevel.size() > 0) {
              // 准备用来存放下一层的结点
              List<TreeNode> nextLevel = new ArrayList<>();
              // 用来存放当前层的结果
              List<Integer> curResult = new ArrayList<>();
              // 遍历当前层的每个结点
              for (TreeNode cur: curLevel) {
                // 把当前层的值存放到当前结果里面
                curResult.add(cur.val);
                // 生成下一层
                if (cur.left != null) {
                  nextLevel.add(cur.left);
                }
                if (cur.right != null) {
                  nextLevel.add(cur.right);
                }
              }
              // 注意这里的更迭!滚动前进
              curLevel = nextLevel;
              // 把当前层的值放到结果里面
              ans.add(curResult);
        }
        return ans;
  }
}
