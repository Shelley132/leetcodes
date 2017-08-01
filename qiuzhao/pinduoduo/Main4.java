package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JUANJUAN
 * @version 2017年8月1日下午9:14:08
*/
public class Main4 {
	 //设置最大值  
    int MAX=999;  
    //顶点总个数  
    int total;  
    //邻接矩阵表示距离  
    int[][] matrix;  
    //结点相关信息  
    String[] nodes;  
    //存储最后结果  
    int[] dis;  
    //标记结点  
    int[] mark;  
  
   private void dijkstra1(int s)  
   {  
       for(int i=0;i<total;i++ )  
           mark[i]=0;  
       mark[s]=1;  
       for(int i=0;i<total;i++)  
       {  
           dis[i]=matrix[s][i];  
       }  
       /**每次找到一个最小值，标记，然后修改其相邻的值*/  
       for(int i=0;i<total;i++)  
       {  
           int min=MAX;  
           int index=-1;  
           for(int j=0;j<total;j++)  
           {  
               if(mark[j]==0&&dis[j]<min)  
               {  
                   index=j;  
                   min=matrix[s][j];  
               }  
           }  
           if(index==-1) return;  
           mark[index]=1;  
           for(int k=0;k<total;k++)  
           {  
               if(mark[k]==0&&dis[index]+matrix[index][k]<dis[k])  
               {  
                   dis[k]=dis[index]+matrix[index][k];  
               }  
           }  
          // printDis(0,this.nodes[i],"第"+i+"次");  
       }  
   }  
   private void printDis(int i, String node, String pre) {    
       /*System.out.print("\n" + pre + "," + node + "," + i + "--->");   
       for (int t = 0; t < this.dis.length; t++) {   
           System.out.print(t + ",");   
       }*/   
       System.out.print("\n" + pre + i + "--->");    
       for (int t : this.dis) {    
           System.out.print(t + ",");    
       }    
       System.out.print("\n");    
   }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		char[][] matrix = new char[m][n];
		scan.nextLine();
		int startI = 0, startJ = 0;
		int endI =0, endJ = 0;
		int aI =0, aJ =0;
		int AI = 0, AJ =0;
		
		for(int i =0; i< m; i++){
			String s = scan.nextLine();
			for(int j = 0; j< n; j++){
				char c = s.charAt(j);
				if(c=='2'){
					startI = i;
					startJ = j;
				}else if(c=='3'){
					endI =i;
					endJ = j;
				}else if(c >='a' && c <='z'){
					aI =i;
					aJ= j;
				}else if(c >='A'&& c <='Z'){
					AI =i;
					AJ =j;
				}
				matrix[i][j]= c;
			}
		}
		for(int i=0; i< m; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		//先到钥匙处，再由钥匙处到大门处，再到出口。
		//Dijkstra算法求最短路径
		
		
		scan.close();
	}
}
