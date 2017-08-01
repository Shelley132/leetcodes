package leetcodes1_50;

/**
 * @author JUANJUAN
 * @version 2017年6月16日上午10:56:37
 */
public class L9回文数 {

	/**
	 * 没有额外空间，判断一个整数是否为回文整数
	 * 
	 * @author JUANJUAN
	 * @version 2017年6月16日上午10:57:13
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		if (x == reverse(x)) {
			return true;
		}
		return false;
	}

	public long reverse(int x) {
		long res = 0;
		while (x != 0) {
			int tmp = x % 10;
			res = res * 10 + tmp;
			x /= 10;
		}
		return res;
	}
	//机智解法，不除到个位上，防溢出
	public boolean isPalindrome2(int x) {
	    
	    if (x < 0) return false;

	    int p = x; 
	    int q = 0; 
	    
	    while (p >= 10){
	        q *=10; 
	        q += p%10; 
	        p /=10; 
	    }
	    
	    return q == x / 10 && p == x % 10;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L9回文数 test = new L9回文数();

		System.out.println(test.isPalindrome(121));
		System.out.println(test.isPalindrome(122));
		System.out.println(test.isPalindrome(12121));
		System.out.println(test.isPalindrome(12221));
	}

}
