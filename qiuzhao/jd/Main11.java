package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author JUANJUAN
 * @version 2017年9月8日下午8:42:50
 */
public class Main11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int n = s.length();
		int sum = 1, cnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				cnt++;
			} else {
				sum *= cnt;
				cnt--;
			}
		}
		System.out.println(sum);
		scan.close();
	}
}
