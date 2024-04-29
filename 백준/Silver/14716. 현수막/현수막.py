# 14716
from collections import deque
import sys
sys.setrecursionlimit(10**6)

m, n = map(int, input().split())
board = []
visited = [[0 for _ in range(n)] for _ in range(m)]

q = deque()
dx, dy = [-1, 0, 0, 1, -1, -1, 1, 1], [0, -1, 1, 0, -1, 1, -1, 1]
cnt = 0

for i in range(m):
    arr = list(map(int, input().split()))
    board.append(arr)
    
    for j in range(len(arr)):
        if arr[j] == 1:
            q.append((i, j))


def dfs(x, y):
    for i in range(len(dx)):
        nx, ny = x + dx[i], y + dy[i]
        
        # 예외처리
        if nx < 0 or ny < 0 or nx >= m or ny >= n:
            continue
        if visited[nx][ny] != 0:
            continue
        
        if board[nx][ny] == 1:
            visited[nx][ny] = 1
            dfs(nx, ny)
    return
            
            
while q:
    x, y = q.popleft()
    if visited[x][y] == 0:
        visited[x][y] = 1
        dfs(x, y)
        cnt += 1
        
print(cnt)