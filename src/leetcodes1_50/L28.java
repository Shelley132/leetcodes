package leetcodes1_50;

/**
 * @author JUANJUAN
 * @version 2017年7月5日上午11:47:11
 */
public class L28 {
	/**
	 * needle在haystack中第一次出现的位置
	 * 
	 * @author JUANJUAN
	 * @version 2017年7月5日上午11:49:27
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if(needle.equals(haystack)){
			return 0;
		}
		if(needle.length()> haystack.length()){
			return -1;
		}
		for(int i=0; i< haystack.length(); i++){
			if(i+needle.length()<=haystack.length() && needle.equals(haystack.substring(i, i+needle.length()))){
				return i;
			}
		}
		return -1;
	}
	
	public int strStr2(String haystack, String needle){
		for (int i = 0; ; i++) {
		    for (int j = 0; ; j++) {
		      if (j == needle.length()) return i;
		      if (i + j == haystack.length()) return -1;
		      if (needle.charAt(j) != haystack.charAt(i + j)) break;
		    }
		  }
	}
}
