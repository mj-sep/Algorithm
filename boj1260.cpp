#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int g_node[1001][1001]; // 인접행렬 그래프
bool visited[1001];
int node, edge, vertex;

// 리셋
void reset() {
    for (auto i = 1; i <= node; i++) {
        visited[i] = false;
    }
}

// 깊이우선탐색
void dfs(int vertex) {
    visited[vertex] = true;
    cout << vertex << " ";

    for (int i = 1; i <= node; i++) {
        if (visited[i] == 1 || g_node[vertex][i] == 0) {
            continue;
        }
        dfs(i);
    }
}

// 너비우선탐색
void bfs(int vertex) {
    queue<int> q;
    visited[vertex] = true;
    cout << vertex << " ";
    q.push(vertex);

    while (!q.empty()) {
        vertex = q.front();
        q.pop();

        for (auto i = 1; i <= node; i++) {
            if (g_node[vertex][i] == 1 && visited[i] == 0) {
                q.push(i);
                visited[i] = true;
                cout << i << " ";
            }
        }
    }

}


int main() {
    
    cin >> node >> edge >> vertex;

    //  간선이 연결하는 두 정점의 번호
    for (auto i = 0; i < edge; i++) {
        int x, y;
        cin >> x >> y;
        g_node[x][y] = 1;
        g_node[y][x] = 1;
    }
    
    reset();
    dfs(vertex);
    cout << endl;
    reset();
    bfs(vertex);

}
