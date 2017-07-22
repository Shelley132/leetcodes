package leetcodes1_50;

/**
 * @author JUANJUAN
 * @version 2017年6月29日上午11:36:46
*/
public class L12IntegerToRoman {
	public String intToRoman(int num) {
        String res = "";
        //1,2,3,4,5,6,7,8,9
        //10,20,30,40,50,60,70,80,90
        //100,200,300,400,500,600,700,800,900
        //1000,2000,3000
        String[] arr = {"I","II","III","IV", "V", "VI","VII", "VIII", "IX","X","XX","XXX","XL", "L", "LX","LXX","LXXX", "XC","C", "CC","CCC", "CD", "D","DC","DCC","DCCC","CM","M","MM","MMM"};
      
        int i =0;
        while(num>0){
        	int bits = num%10;
        	//System.out.println(arr[9*i+bits]);
        	if(bits!=0){
        		res = arr[9*i+bits-1] + res;
        	}
        	num = num/10;
        	i++;
        }
        return res;
    }
	
	public String intToRoman2(int num){
		StringBuffer sb = new StringBuffer();
		int[] arri = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		for(int i=0; i< arri.length; i++){
			while(num >= arri[i]){
				sb.append(strs[i]);
				num-=arri[i];
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new L12IntegerToRoman().intToRoman(412));
	}

}
