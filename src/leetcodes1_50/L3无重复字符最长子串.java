package leetcodes1_50;

import java.util.HashMap;

/**
 * @author JUANJUAN
 * @version 2017年6月14日下午4:12:17
 */
public class L3无重复字符最长子串 {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0 || s.length() == 1)
            return s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int right = 0, left = 0, max = 0;
        map.put(s.charAt(0), 0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            right = i;
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index >= left) {
                    left = index + 1;
                }
            }
            map.put(c, i);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
