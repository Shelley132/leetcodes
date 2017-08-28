package souhu17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。 
输入描述:
输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 1000。第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。

 * @author JUANJUAN
 * @version 2017年8月28日下午1:50:30
*/
public class Main1 {
	public static void sortK(String num, int[] arr, int k) {
		int len = arr.length - 1;
		int beginIndex = (len - 1) >> 1;// 第一个非叶子节点
		for (int i = beginIndex; i >= 0; i--) {
			maxHeapify(num, arr, i, len);
		}
		for (int i = len; i >= len - k; i--) {
			swap(arr, 0, i);
			maxHeapify(num, arr, 0, i - 1);
		}
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void maxHeapify(String num, int[] arr, int index, int len) {
		int li = (index << 1) + 1; // 左子节点索引
		int ri = li + 1; // 右子节点索引
		int cMax = li; // 子节点值最大索引，默认左子节点。

		if (li > len)
			return; // 左子节点索引超出计算范围，直接返回。
		if (ri <= len && num.charAt(arr[ri]) > num.charAt(arr[li])) // 先判断左右子节点，哪个较小。
			cMax = ri;
		if (num.charAt(arr[cMax]) > num.charAt(arr[index])) {
			swap(arr, cMax, index); // 如果父节点被子节点调换，
			maxHeapify(num, arr, cMax, len); // 则需要继续判断换下后的父节点是否符合堆的特性。
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		int k = scan.nextInt();
		
		int[] idx = new int[num.length()];
		for(int i=0; i< num.length(); i++){
			idx[i]=i;
		}
		sortK(num, idx, k);
		for(int i=0; i< k; i++){
			System.out.println(num.charAt(idx[i]));
		}
		System.out.println(Arrays.toString(idx));
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<k; i++){
			set.add(idx[i]);
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< num.length(); i++){
			if(!set.contains(i))
				sb.append(num.charAt(i));
		}
		System.out.println(sb.toString());
		scan.close();
	}

}
