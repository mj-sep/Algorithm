#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int node, edge, vertex;
int g_node[1001][1001];
int isVisited[1001];
vector<int> v;

// bfs
void bfs(int vertex) {
    queue<int> q;
    isVisited[vertex] = true;
    v.push_back(vertex);
    q.push(vertex);

    while (!q.empty()) {
        vertex = q.front();
        q.pop();
        
        for (auto i = 1; i <= node; i++) {
            if (isVisited[i] == 0 && g_node[vertex][i] == 1) {
                q.push(i);
                isVisited[i] = true;
                v.push_back(i);
            }
        }
    }
}

int main() {
    int vertex = 1;
    cin >> node;
    cin >> edge;

    for (int i = 0; i < edge; i++) {
        int x, y;
        cin >> x >> y;
        g_node[x][y] = 1;
        g_node[y][x] = 1;
    }

    bfs(vertex);
    cout << v.size() - 1; // 1번 컴퓨터 제외
    
}
