package leetcodes1_50;

import java.util.Arrays;

/**
 * @author JUANJUAN
 * @version 2017年7月7日上午9:57:13
 */
public class L31 {
    public void nextPermutation(int[] nums) {
        int i, j;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        //System.out.println(i);
        if (i == 0) {
            Arrays.sort(nums);
        } else {
            for (j = nums.length - 1; j >= i; j--) {
                if (nums[i - 1] < nums[j]) {
                    break;
                }
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
            reverse(nums, i);
            Arrays.sort(nums, i, nums.length);
        }

        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int i) {
        int start = i;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        L31 test = new L31();
        int[] nums = {1, 3, 2};
        test.nextPermutation(nums);
    }
}
