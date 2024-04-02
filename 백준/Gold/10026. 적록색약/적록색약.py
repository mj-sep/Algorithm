import sys

sys.setrecursionlimit(10**6)
n = int(input())
arr = []
visited = [[0 for _ in range(n)] for _ in range(n)]
dx, dy = [-1, 0, 0, 1], [0, -1, 1, 0]

for _ in range(n):
    arr_list = list(map(str, input()))
    arr.append(arr_list)
    
territory = 0
territory2 = 0

def dfs(vx, vy, color):
    visited[vx][vy] = 1
    
    for i in range(len(dx)):
        nx = vx + dx[i]
        ny = vy + dy[i]
        if 0 <= nx <= n-1 and 0 <= ny <= n-1 and visited[nx][ny] == 0:
            if arr[nx][ny] == color:
                dfs(nx, ny, color)
                    
for c in ['R', 'G', 'B']:
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0 and arr[i][j] == c:
                dfs(i, j, c)
                territory += 1
                                
for i in range(n):
    for j in range(n):
        if arr[i][j] == 'G': arr[i][j] = 'R'

visited = [[0 for _ in range(n)] for _ in range(n)]
for c in ['R', 'B']:
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0 and arr[i][j] == c:
                dfs(i, j, c)
                territory2 += 1
        
print(territory, territory2)