package leetcodes51_100;

/**
 * @author JUANJUAN
 * @version 2017年7月28日下午7:24:13
 */
public class L81 {
	public boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[start] < nums[mid] || nums[mid] > nums[end]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			} else

			if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else {
				end--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		L81 test = new L81();
		int[] nums = { 1, 1, 3, 1 };
		boolean res = test.search(nums, 3);
		System.out.println(res);
	}
}
