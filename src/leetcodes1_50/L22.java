package leetcodes1_50;

import java.util.LinkedList;
import java.util.List;

/**
 * @author JUANJUAN
 * @version 2017年7月4日下午4:13:47
*/
public class L22 {
	public List<String> generateParenthesis(int n) {
		List<String> list = new LinkedList<String>();
		String s = "";
		generate(n, n, s, (LinkedList<String>) list);
		return list;
	}

	private void generate(int leftNum, int rightNum, String s, LinkedList<String> result) {
		//当左右值为0时，得到一个合法排列
		if (leftNum == 0 && rightNum == 0) {
			result.push(s);
		}
		//如果左值大于0，则可以继续大于左括号
		if (leftNum > 0) {
			generate(leftNum - 1, rightNum, s + '(', result);
		}
		//如果右值大于0并且左值小于右值，只能打印右括号
		if (rightNum > 0 && leftNum < rightNum) {
			generate(leftNum, rightNum - 1, s + ')', result);
		}
	}

	 public static void main(String[] args) {
		L22 test = new L22();
		List<String> list = test.generateParenthesis(3);
		for(String s: list){
			System.out.println(s);
		}
		
		
	}
}
