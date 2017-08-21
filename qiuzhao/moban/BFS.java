package moban;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author LLJ
 * @version 2017年8月4日下午5:35:38
*/
public class BFS {
	public static Queue<Node> que = new LinkedList<Node>();
	public static int[] fx = {0, 0, 1, -1};
	public static int[] fy = {1, -1, 0, 0};
	public static int bfs(int sx, int sy, int ex, int ey, char[][] mz, int m, int n, Map<Character, Integer> keys, boolean[][][] visited) {
		while(!que.isEmpty()) que.poll();
		Node tmp = new Node();
		tmp.x = sx;
		tmp.y = sy;
		que.offer(tmp);
		while(!que.isEmpty()) {
			//取队列头结点
			Node p = que.poll();
			if(p.x == ex && p.y == ey) {
				return p.cnt;
			}
			//每次由头结点分别向右左下上探路，有路且没有走过就加入队列中，
			for(int i = 0; i < 4; ++i) {
				//看新结点是否能到达。
				int newx = p.x + fx[i];
				int newy = p.y + fy[i];
				if(newx < 0 || newx >= m || newy < 0 || newy >= n) continue;
				if(mz[newx][newy] == '0') continue;
				int sta = p.sta;
				//记录一下碰到锁了
				if(mz[p.x][p.y] >= 'a' && mz[p.x][p.y] <= 'z') {
					sta |= (1<<keys.get(mz[p.x][p.y]));	
				}
				//如果这把锁已经用过了，跳过本次循环
				if(visited[newx][newy][sta]) continue;
				if(mz[newx][newy] >= 'A' && mz[newx][newy] <= 'Z') {
					char c= (char) (mz[newx][newy] - 'A' + 'a');
					if((sta & (1<<keys.get(c)))== 0) {
						continue;
					}
				}
				visited[newx][newy][sta] = true;
				tmp = new Node();
				tmp.x = newx;
				tmp.y = newy; 
				tmp.cnt = p.cnt + 1;
				tmp.sta = sta;
				//压入队列
				que.offer(tmp);
				
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		char[][] matrix = new char[m][n];
		boolean[][][] visited = new boolean[m][n][n*10];
		scan.nextLine();
		int sx=0, sy=0, ex=0, ey=0;
		Map<Character, Integer> keys = new HashMap<Character, Integer>();
		int cnt = 0;
		for(int i =0; i< m; i++){
			String s = scan.nextLine();
			for(int j = 0; j< n; j++){
				char c = s.charAt(j);
				if(c=='2'){
					sx = i;
					sy = j;
				}else if(c=='3'){
					ex =i;
					ey = j;
				}else if(c >='a' && c <='z'){
					keys.put(c, cnt++);
				}
				matrix[i][j]= c;
			}
		}
		System.out.println(keys);
		for(int i=0; i< m; i++){
			for(int j =0; j <n; j++){
				//cnt把钥匙，则对应了2^cnt种状态
				for(int k =0; k<(1<<cnt); k++){
					visited[i][j][k] = false;
				}
			}
		}
		int res = bfs(sx,sy, ex,ey, matrix,  m,  n, keys, visited);
		System.out.println(res);
		scan.close();
	}

}
