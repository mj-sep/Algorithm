# 17086
from collections import deque

n, m = map(int, input().split())
arr = []
q = deque()
dx, dy = [1, 0, 0, -1, 1, 1, -1, -1], [0, 1, -1, 0, 1, -1, 1, -1]
max_ = 0
visited = [[-1 for _ in range(m)] for _ in range(n)]

for i in range(n):
    arr_ = list(map(int, input().split()))
    for j in range(len(arr_)):
        if arr_[j] == 1: # 상어 위치
            q.append((i, j))
            visited[i][j] = 0
    arr.append(arr_)

while q:
    x, y = q.popleft()
    for i in range(len(dx)):
        nx, ny = x + dx[i], y + dy[i]
        
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if arr[nx][ny] == 1:
            visited[nx][ny] = 0
            continue
        
        if visited[nx][ny] == -1:
            visited[nx][ny] = visited[x][y] + 1
            q.append((nx, ny))
        else:   
            visited[nx][ny] = min(visited[nx][ny], visited[x][y] + 1)
        max_ = max(max_, visited[nx][ny])
        

print(max_)