package leetcodes1_50;

/**
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * @author JUANJUAN
 * @version 2017年6月25日下午2:30:35
 */
public class L10正则表达式匹配 {
	public boolean isMatch(String s, String p) {

	    if (s == null || p == null) {
	        return false;
	    }
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
	    }
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            if (p.charAt(j) == '.') {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == '*') {
	                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                } else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	    return dp[s.length()][p.length()];
	}
	
	
	public boolean isMatch2(String s, String p){
		if(s==null ||p==null){
			return false;
		}
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		////初始化第0行,除了[0][0]全为false，毋庸置疑，因为空串p只能匹配空串，其他都无能匹配
		dp[0][0]= true;
		for (int i = 1; i <= s.length(); i++) 
		    dp[i][0] = false; 
		//只有p是X*，才与s匹配
		for(int j =1; j<=p.length();j++){
			 dp[0][j] = j > 1 && '*' == p.charAt(j-1) && dp[0][j - 2];
		}
		for(int i = 1;i <= s.length();i++)
		{
		    for(int j = 1;j <= p.length();j++)
		    {
		        //这里j-1才是正常字符串中的字符位置
		        //要不*当空，要不就只有当前字符匹配了*之前的字符，才有资格传递dp[i-1][j]真值
		        if(p.charAt(j-1) == '*')
		            dp[i][j] = dp[i][j-2] || (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j];
		        else 
		        //只有当前字符完全匹配，才有资格传递dp[i-1][j-1] 真值
		            dp[i][j] = (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) && dp[i-1][j-1];
		    }
		}
		return  dp[s.length()][p.length()];
	}
	public static void main(String[] args) {
		L10正则表达式匹配 test = new L10正则表达式匹配();
		System.out.println(test.isMatch2("aaabc", "a*bc"));
	}
}
