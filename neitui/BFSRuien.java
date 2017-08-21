import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int x, y;
	int step;
	int havkey;
}

public class BFSRuien {
	public static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static int bfs(int[][] keys, int n, int m, boolean[][][] vis, int[][][][] door) {
		Queue<Node> que = new LinkedList<Node>();
		Node st = new Node();
		st.x = 1;
		st.y = 1;
		st.havkey = keys[1][1];
		que.offer(st);
		while (!que.isEmpty()) {
			Node cur = que.poll();
			if (cur.x == n && cur.y == m)
				return cur.step;
			for (int i = 0; i < 4; i++) {
				int tx = cur.x + dir[i][0];
				int ty = cur.y + dir[i][1];
				if (tx >= 1 && tx <= n && ty >= 1 && ty <= m) {
					int usekey = door[cur.x][cur.y][tx][ty];
					// 为0，没法过去
					if (usekey == 0)
						continue;
					// 看现在有的钥匙有没有需要的钥匙，假设当前有的钥匙表示为10000001010，也就是用于1,3,10.
					// 而需要的钥匙为2，右移两位得到100000010，与1与得0，则没有钥匙，否则有钥匙可以过去了
					if (usekey == -1 || (((cur.havkey >> usekey) & 1)) == 1) {
						Node nod = new Node();
						nod.x = tx;
						nod.y = ty;
						nod.step = cur.step + 1;
						nod.havkey = cur.havkey | keys[tx][ty];// nod现有的钥匙应该是上一步带的钥匙加当前格子里有的钥匙
						if (vis[nod.x][nod.y][nod.havkey] == false) {
							vis[nod.x][nod.y][nod.havkey] = true;
							que.offer(nod);
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextInt()) {
			int[][][][] door = new int[20][20][20][20];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					for (int k = 0; k < 20; k++) {
						Arrays.fill(door[i][j][k], -1);
					}
				}
			}
			int[][] keys = new int[20][20];
			for (int i = 0; i < 20; i++) {
				Arrays.fill(keys[i], 0);
			}
			boolean[][][] vis = new boolean[20][20][1 << 11];
			for (int i = 0; i < 20; i++) {
				for (int j = 0; j < 20; j++) {
					Arrays.fill(vis[i][j], false);
				}
			}
			int n = scan.nextInt();
			int m = scan.nextInt();
			int p = scan.nextInt();
			int x1, x2, y1, y2, g, q;
			int k = scan.nextInt();

			for (int l = 0; l < k; l++) {
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				x2 = scan.nextInt();
				y2 = scan.nextInt();
				g = scan.nextInt();
				door[x1][y1][x2][y2] = door[x2][y2][x1][y1] = g;
			}

			int s = scan.nextInt();
			for (int l = 0; l < s; l++) {
				x1 = scan.nextInt();
				y1 = scan.nextInt();
				q = scan.nextInt();
				keys[x1][y1] |= (1 << q);
			}
			for (int i = 0; i < 20; i++) {
				Arrays.toString(door[i]);
			}
			int ans = bfs(keys, n, m, vis, door);
			System.out.println(ans);

		}
		scan.close();
	}
}
