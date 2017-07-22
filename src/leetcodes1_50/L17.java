package leetcodes1_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author JUANJUAN
 * @version 2017年6月30日上午8:50:41
 */
public class L17 {
	public List<String> letterCombinations(String digits) {
		// 0,1,2,3,4,5,6,7,8,9
		List<String> list = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return list;
		}
		String[] strs = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		for (int i = 0; i < digits.length(); i++) {
			// 得到当前位上的数字
			int c = digits.charAt(i) - '0';
			// 得到当前位数字对应的字符们
			String s = strs[c];
			if (i == 0) {
				for (int j = 0; j < s.length(); j++) {
					list.add(s.charAt(j) + "");
				} 
			}else{
				List<String> newList = new ArrayList<String>();
				for (int k = 0; k < list.size(); k++) {
					for (int j = 0; j < s.length(); j++) {
						newList.add(list.get(k) + s.charAt(j));	
					}
				}
				if (newList.size() > list.size()) {
					list = newList;
				}
			}
		}
		return list;
	}
	
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> list = new LinkedList<String>();
		if (digits == null || digits.length() == 0) {
			return list;
		}
		String[] strs = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		list.add("");
		for(int i=0; i< digits.length();i++){
			 int x = Character.getNumericValue(digits.charAt(i));
		        while(list.peek().length()==i){
		            String t = list.remove();
		            for(char s : strs[x].toCharArray())
		            	list.add(t+s);
		        }
		}
	
		return list;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L17 test = new L17();
		System.out.println(test.letterCombinations("236"));
		System.out.println(test.letterCombinations2("236"));
	}

}
