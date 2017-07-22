package leetcodes51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JUANJUAN
 * @version 2017年7月21日下午8:55:22
 */
public class L76 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	//我写的是多次调用rec，而方法2只调用了一次，其实不用多次rec调用,可以被注释掉
	public List<List<Integer>> combine(int n, int k) {
		/*for (int i = 1; i <= n - k + 1; i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(i);
			rec(list, i + 1, n, k);
		}*/
		List<Integer> list = new ArrayList<Integer>();
		rec(list, 1, n, k);
		return res;
	}

	public void rec(List<Integer> list, int start, int n, int k) {
		if (list.size() == k) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		// 添加
		for (int i = start; i <= n; i++) {
			list.add(i);
			rec(list, i + 1, n, k);
			list.remove(list.size() - 1);
		}
	}

	public static List<List<Integer>> combine2(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}
	public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if (k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for (int i = start; i <= n; i++) {
			comb.add(i);
			combine(combs, comb, i + 1, n, k - 1);
			comb.remove(comb.size() - 1);
		}
	}

}
