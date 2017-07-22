package leetcodes1_50;

import java.util.Arrays;

/**
 * @author JUANJUAN
 * @version 2017年7月10日下午2:16:01
*/
public class L43 {
	public String multiply(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int n1 = num1.length();
		int n2 = num2.length();
		int[][] dp = new int[n1+1][n2+1];
		int jinwei = 0;
		for(int i= n1-1; i>=0; i--){
			int bit1 = num1.charAt(i)-'0';
			for(int j = n2-1; j >=0; j--){
				int bit2 = num2.charAt(j)-'0';
				int mul = bit1* bit2 + jinwei;
				dp[i+1][j+1] = mul%10;
				jinwei = mul/10;
			}
			dp[i+1][0]=jinwei;
			jinwei =0;
		}
		//计算这个矩阵的反斜线上的值
		jinwei =0;
		for(int k= n1+n2; k >0; k--){
			int sum = 0;
			for(int i = n1; i >=0; i--){
				if(k-i<= n2 && k-i >=0){
					sum+= dp[i][k-i];
				}
			}
			sb.append((sum+jinwei)%10);
			jinwei = (sum+jinwei)/10;
		}
		sb = sb.reverse();
        int start = 0;
		for(int i= 0; i<sb.length();i++){
			if(sb.charAt(i)=='0'){
				start++;
			}else{
				break;
			}
		}
        String res = sb.substring(start, sb.length());
		return res.equals("")?"0":res;
	}
	//优化				这一列
	//		[0, 0, 0, 0, 0, 0]
	//		[0, 1, 6, 3, 5, 0]这一行
	//		[0, 5, 0, 7, 6, 0]
	//		[0, 5, 6, 4, 0, 0]
	//		[0, 0, 0, 0, 0, 0]
	public String multiply2(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int n1 = num1.length();
		int n2 = num2.length();
		int[][] dp = new int[n1+2][n2+2];
		int jinwei = 0;
		for(int i= n1-1; i>=0; i--){
			int bit1 = num1.charAt(i)-'0';
			for(int j = n2-1; j >=0; j--){
				int bit2 = num2.charAt(j)-'0';
				int mul = bit1* bit2 + jinwei + dp[i+2][j];
				dp[i+1][j+1] = mul%10;
				jinwei = mul/10;
			}
			dp[i+1][0]=jinwei;
			jinwei =0;
		}
		boolean start = true;
		for(int i=0; i<=n2; i++){
			if(dp[1][i]==0 && start){
				
			}else{
				sb.append(dp[1][i]);
				start = false;
			}
		}
		for(int i=2; i <=n1; i++){
			sb.append(dp[i][n2]);
		}
		return sb.toString().equals("")?"0":sb.toString();
	}
	//再优化，把二维数组改为一维
	public String multiply3(String num1, String num2) {
		int n1 = num1.length();
		int n2 = num2.length();
		int[] nums = new int[n1+n2];
		int jinwei = 0;
		int k = n1+n2-1;
		for(int i= n1-1; i>=0; i--){
			int bit1 = num1.charAt(i)-'0';
			for(int j = n2-1; j >=0; j--){
				int bit2 = num2.charAt(j)-'0';
				int mul = bit1* bit2 + jinwei+ nums[k];
				nums[k] = mul%10;
				jinwei = mul/10;
				k--;
			}
			k=i+n2-1;
			nums[k] =jinwei;
			jinwei =0;
		}
		StringBuilder sb = new StringBuilder();
		boolean start = true;
		for(int i=0; i< nums.length; i++){
			if(nums[i]==0 && start){
				
			}else{
				sb.append(nums[i]);
				start = false;
			}
			
		}
		
		System.out.println(Arrays.toString(nums));
		return sb.toString().equals("")?"0":sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L43 test = new L43();
		System.out.println(test.multiply3("9", "9"));
	}

}
