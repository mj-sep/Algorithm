#include<iostream>
#include<vector>
#include<stack>
#include<queue>

using namespace std;

int t, m, n, k, x, y;
int graph[51][51];

// dfs 
bool dfs(int x, int y) {
	// 판을 벗어나면 false
	if (x < 0 || x >= m || y < 0 || y >= n) {
		return false;
	}

	// 처음 방문한 노드인 경우
	if (graph[x][y] == 1) {
		graph[x][y] = 0;
		dfs(x - 1, y);
		dfs(x + 1, y);
		dfs(x, y - 1);
		dfs(x, y + 1);
		return true;
	}
	return false;
}

int main(){
	vector<int> v;
	cin >> t;

	// 테스트 케이스가 1개 이상이므로 케이스 1개 입력 받고 바로 dfs 실행
	for (int i = 0; i < t; i++) {
		int result = 0;
		cin >> m >> n >> k;
		for (int j = 0; j < k; j++) {
			cin >> x >> y;
			graph[x][y] = 1;
		}
		// 테스트 케이스 1번부터 dfs 실행
		for (int q = 0; q < m; q++) {
			for (int r = 0; r < n; r++) {
				if (dfs(q, r)) {
					result += 1;
				}
			}
		}
		// 테스트 케이스 순서대로 결과값 vector에 저장
		v.push_back(result);
	}

	for (int i = 0; i < v.size(); i++) {
		cout << v[i] << "\n";
	}
}
