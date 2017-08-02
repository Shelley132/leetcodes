#include <cstdio>
#include <iostream>
#include <string>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;
const int N = 110;
char mz[N][N];
bool vis[N][N][N*10];
int fx[4] = {0, 0, 1, -1};
int fy[4] = {1, -1, 0, 0};
int m, n;
map<char, int> key;

struct node {
	int x, y, cnt, sta;
	node():cnt(0), sta(0) {}
};
queue<node> que;

int bfs(int sx, int sy, int ex, int ey) {
	while(!que.empty()) que.pop();
	node tmp;
	tmp.x = sx, tmp.y = sy;
	que.push(tmp);

	while(!que.empty()) {
		node p = que.front();
		if(p.x == ex && p.y == ey) {
			return p.cnt;
		}
		que.pop();

		for(int i = 0; i < 4; ++i) {
			int newx = p.x + fx[i];
			int newy = p.y + fy[i];
			if(newx < 0 || newx >= m || newy < 0 || newy >= n) continue;
			if(mz[newx][newy] == '0') continue;
			int sta = p.sta;
			if(mz[p.x][p.y] >= 'a' && mz[p.x][p.y] <= 'z') {
				sta |= (1<<key[mz[p.x][p.y]]);
			}
			if(vis[newx][newy][sta]) continue;
			if(mz[newx][newy] >= 'A' && mz[newx][newy] <= 'Z') {
				if((sta & (1<<(key[mz[newx][newy] - 'A' + 'a'])))== 0) {
					continue;
				}
			}
			vis[newx][newy][sta] = true;
			tmp.x = newx, tmp.y = newy, tmp.cnt = p.cnt + 1, tmp.sta = sta;
			que.push(tmp);
		}
	}
	return -1;
}

int main() {
	while(~scanf("%d %d", &m, &n)) {
		int sx, sy, ex, ey;
		int cnt = 0;
		for(int i = 0; i < m; ++i) {
			scanf("%s", mz[i]);
			for(int j = 0; j < n; ++j) {
				if(mz[i][j] == '2') {
					sx = i, sy = j;
				}
				if(mz[i][j] == '3') {
					ex = i, ey = j;
				}
				if(mz[i][j] >= 'a' && mz[i][j] <= 'z') {
					key[mz[i][j]] = cnt++;
				}
			}
		}

		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				for(int s = 0; s < (1<<cnt); ++s) {
					vis[i][j][s] = false;
				}
			}
		}

		int Ans = bfs(sx, sy, ex, ey);
		printf("%d\n", Ans);
	}
	return 0;
}