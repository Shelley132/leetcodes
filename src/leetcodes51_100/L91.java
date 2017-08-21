package leetcodes51_100;

import java.util.Arrays;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午11:14:22
 */
public class L91 {
	public int numDecodings(String s) {
		if(s==null ||s.length()==0 || s.startsWith("0")){
			return 0;
		}
		if(s.matches("(10)*")){
			return 1;
		}
		//System.out.println("======");
		int n = s.length();
		int[][] dp = new int[n+1][n+1];
		for(int i=0; i< n; i++){
			for(int j =i+1; j <=(n > i+2?i+2: n); j++){
				String tmp = s.substring(i,j);
				if(tmp.startsWith("0")){
					break;
				}
				int num = Integer.parseInt(tmp);
				if(num <=26){
					if(i==0){
						dp[i][j]= 1;
					}else{
						for(int k =0; k<i; k++){
							dp[i][j]+=dp[k][i];
						}
					}
				}
				
			}
		}
		int res = 0;
		for(int i=0; i<=n; i++){
			res+= dp[i][n];
		}
		return res;
	}
	
	 public int numDecodings2(String s) {
	        int n = s.length();
	        if (n == 0) return 0;
	        
	        int[] memo = new int[n+1];
	        memo[n]  = 1;
	        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
	        System.out.println(Arrays.toString(memo));
	        for (int i = n - 2; i >= 0; i--)
	            if (s.charAt(i) == '0') continue;
	            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
	        System.out.println(Arrays.toString(memo));
	        return memo[0];
	    }
	public static void main(String[] args) {
		L91 test = new L91();
		int res = test.numDecodings2("1216");
		System.out.println(res);
	}
}
