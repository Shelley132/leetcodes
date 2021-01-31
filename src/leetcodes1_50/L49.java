package leetcodes1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUANJUAN
 * @version 2017年7月11日下午3:14:38
 */
public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<int[]> mark = new ArrayList<int[]>();

        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                int c = strs[i].charAt(j) - 'a';
                count[c]++;
            }
            int k = hasArrays(mark, count);
            if (k == -1) {
                List<String> cur = new ArrayList<String>();
                cur.add(strs[i]);
                mark.add(mark.size(), count);
                res.add(cur);
            } else {
                List<String> cur = res.get(k);
                cur.add(strs[i]);
            }
        }
        return res;
    }

    public int hasArrays(List<int[]> list, int[] array) {
        int count;
        for (int i = 0; i < list.size(); i++) {
            count = 0;
            int[] a = list.get(i);
            for (int j = 0; j < a.length; j++) {
                if (a[j] == array[j]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == array.length) {
                return i;
            }

        }
        return -1;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // 拿到一个String转换成charArray,排序，得到的char[]转换成String
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> mark = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            if (mark.contains(s)) {
                int k = 0;
                for (int j = 0; j < mark.size(); j++) {
                    if (mark.get(j).equals(s)) {
                        k = j;
                        break;
                    }
                }
                res.get(k).add(strs[i]);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                res.add(list);
                mark.add(s);
            }
        }
        return res;
    }

    //用map来存储真的机智
    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        L49 test = new L49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = test.groupAnagrams2(strs);
        for (List<String> l : list) {
            for (String s : l) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
