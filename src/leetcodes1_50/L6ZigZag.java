package leetcodes1_50;
/**
 * @author JUANJUAN
 * @version 2017年6月15日上午11:01:22
*/
public class L6ZigZag {
	public String convert(String s, int numRows) {
       
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i=0; i < numRows; i++){
        	sb[i] = new StringBuffer("");
        }
        int index = 0;
        int incre = 1;
        for(int i =0; i< s.length(); i++){
        	sb[index].append(s.charAt(i));
        	if(index == 0){
        		incre = 1;
        	}
        	if(index == numRows-1){
        		incre = -1;
        	}
        	index +=incre;
        }
        StringBuffer res = new StringBuffer();
        for(int i=0; i< numRows; i++){
        	res.append(sb[i]);
        }
        return res.toString();
        
    }
	
	public static void main(String[] args) {
		L6ZigZag test = new L6ZigZag();
		System.out.println(test.convert("PAYPALISHIRING", 3));
	}
}
