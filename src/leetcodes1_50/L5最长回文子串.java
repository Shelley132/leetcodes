package leetcodes1_50;

/**
 * @author JUANJUAN
 * @version 2017年6月14日下午7:45:35
 */
public class L5最长回文子串 {
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }
        String sub = null;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {

            for (int j = i + 1; j <= len; j++) {
                String str = s.substring(i, j);
                if (isPalindraome(str) && str.length() > max) {
                    sub = str;
                    max = str.length();
                }
            }
        }
        return sub;
    }

    public boolean isPalindraome(String sub) {
        int len = sub.length();
        int i = 0;
        while (i <= len / 2) {
            if (sub.charAt(i) == sub.charAt(len - 1 - i)) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

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

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            lo = left + 1;
            maxLen = right - left - 1;
        }
    }

    public static void main(String[] args) {
        String s = "aecbc";

        System.out.println(new L5最长回文子串().longestPalindrome(s));
    }
}
