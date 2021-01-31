package leetcodes1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUANJUAN
 * @version 2017年7月9日下午6:38:25
 */
public class L39 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int[] cans = {};

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.cans = candidates;
        Arrays.sort(cans);
        backTracking(new ArrayList<Integer>(), 0, target);
        return ans;
    }

    public void backTracking(List<Integer> cur, int from, int target) {
        if (target == 0) {
            List<Integer> list = new ArrayList<Integer>(cur);
            ans.add(list);
        } else {
            for (int i = from; i < cans.length && cans[i] <= target; i++) {
                //加入当前元素，递归
                cur.add(cans[i]);
                System.out.println(cur);
                backTracking(cur, i, target - cans[i]);
                //完事后移除当前元素
                cur.remove(new Integer(cans[i]));
                System.out.println("移除后：" + cur);
            }
        }
    }

    public static void main(String[] args) {
        L39 test = new L39();
        int[] nums = {2, 3, 6, 7};
        test.combinationSum(nums, 7);
    }
}
