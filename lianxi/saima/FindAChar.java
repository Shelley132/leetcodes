package saima;

import java.util.Arrays;
import java.util.concurrent.Executors;

/**
 * @author JUANJUAN
 * @version 2017年9月13日上午11:54:32
*/
public class FindAChar {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			String s = "aabbddfdfdsa";
			char[] arr = s.toCharArray();
			char c = 'a';
			int count =0;
			int i=0;
			while(i< arr.length){
				if(arr[i]!=c){
					arr[count++]= arr[i];
				}
				i++;
			}
			for( i=0; i< count; i++){
				System.out.print(arr[i]);
			}
			//Executors.newCachedThreadPool()；
			System.out.println(Arrays.toString(arr));
		

	}

}
