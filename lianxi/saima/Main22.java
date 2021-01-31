package saima;

import java.util.Arrays;

/**
 * @author JUANJUAN
 * @version 2017年8月29日下午4:40:26
 */
public class Main22 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "aabbddfdfdsa";
        char[] arr = s.toCharArray();
        char c = 'a';
        int count = 0;
        int i = 0;
        while (i < arr.length - 2) {
            while (arr[i] == c) {
                arr[count++] = arr[i + 1];
                i++;
            }

            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

}
