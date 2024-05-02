# 1926
from collections import deque
import sys

sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
board = []
q = deque()
dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1]

for i in range(n):
    arr = list(map(int, input().split()))
    board.append(arr)
    
    for j in range(len(arr)):
        if arr[j] == 1:
            q.append((i, j))

def dfs(x, y):
    global max_
    global visited
    for i in range(len(dx)):
        nx, ny = x + dx[i], y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if visited[nx][ny] != 0:
            continue
        
        if board[nx][ny] == 1:
            visited[nx][ny] = 1
            max_ += 1
            dfs(nx, ny)


visited = [[0 for _ in range(m)] for _ in range(n)]
pic = []

while q:
    x, y = q.popleft()
    max_ = 1
    if visited[x][y] == 0:
        visited[x][y] = 1
        dfs(x, y)
        pic.append(max_)
        
print(len(pic))
if pic: print(max(pic))
else: print(0)