
// 이것이 취업을 위한 코딩 테스트다 with 파이썬 (p.153)

#include<iostream>
#include<queue>
using namespace std;

int n, m;
int graph[201][201];


// 상하좌우 이동 가능 방향
int dx[] = { -1, 1, 0 ,0 };
int dy[] = { 0, 0, -1, 1 };

// 미로찾기(bfs)
int maze(int x, int y) {
	// queue pair
	queue<pair<int,int>> q;
	q.push({ x, y });

	// 큐가 빌 때까지 반복
	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;

		q.pop();
		// 현재 위치에서 상하좌우 확인
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			// 미로를 벗어난 경우 무시 (조건문만 무시)
			if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
				continue;
			}
			// 벽인 경우 무시 (==0)
			if (graph[xx][yy] == 0) continue;
			//  처음 방문하는 노드인 경우만 (==1)
			if (graph[xx][yy] == 1) {
				graph[xx][yy] = graph[x][y] + 1; // 위치 번호 부여(1증가)
				q.push({ xx, yy });
			}
		}
	}
	return graph[n - 1][m - 1];
}

int main(){
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf_s("%1d", &graph[i][j]); // 한 자리 수 입력 받기
		}
	}

	cout << maze(0, 0) << "\n";
	return 0;

}
