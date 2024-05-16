# 2589
from collections import deque

h, w = map(int, input().split())
board = []
q = deque()
qc = deque()
dx, dy = [1, 0, 0, -1], [0, 1, -1, 0]

for i in range(h):
    arr = list(input())
    for j in range(len(arr)):
        if arr[j] == 'L':
            q.append((i, j))
    board.append(arr)

max_ = 0
def bfs(visited, qc):
    global max_
    while qc:
        x, y = qc.popleft()
        if visited[x][y] == 0: visited[x][y] = 1
        for i in range(len(dx)):
            nx, ny = x + dx[i], y + dy[i]
            
            if nx < 0 or ny < 0 or nx >= h or ny >= w:
                continue
            if board[nx][ny] == 'W':
                continue
            if visited[nx][ny] != 0:
                continue
            
            visited[nx][ny] = visited[x][y] + 1
            max_ = max(max_, visited[nx][ny])
            qc.append((nx, ny))
        
while q:
    visited = [[0 for _ in range(w)] for _ in range(h)]
    qc.append(q.popleft())
    bfs(visited, qc)
    
    
print(max_-1)

