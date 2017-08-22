package codem;

import java.util.Scanner;

/**
 * @author JUANJUAN
 * @version 2017年6月18日下午6:50:33
*/
public class CodeM2 {
	private int lo, maxLen;
	//中心扩展法，从中间的字母向外一一扩展，找最长回文子串
	//假设字符串是abba，那么i=1时，是从b和b开始对比的，如果字符串是aba，从b和自身开始对比的。
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // 确保奇数长度的子串, try to extend
										// Palindrome as possible
			extendPalindrome(s, i, i + 1); //偶数长度的子串
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		for(int i=0; i< n;i++){
			String s1 = scan.next();
			String s2 = scan.next();
			
			
			
			
			
			
			
			
		}
		scan.close();
	}

}
