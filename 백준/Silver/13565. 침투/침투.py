# 13565
from collections import deque

m, n = map(int, input().split())
board = []
q = deque()
dx, dy = [-1, 0, 0, 1], [0, -1, 1, 0]

for i in range(m):
    arr = list(map(int, input()))
    board.append(arr)
    if i == 0:
        for j in range(len(arr)):
            if arr[j] == 0: q.append((0, j))
    
while q:
    x, y = q.popleft()
    board[x][y] = 2 # 전류가 흐른 영역 = 2
    for i in range(len(dx)):
        nx, ny = x + dx[i], y + dy[i]
        if nx < 0 or ny < 0 or nx >= m or ny >= n:
            continue
        if board[nx][ny] != 0: # 전류가 이미 흐른 영역이거나 벽일 때
            continue
        
        board[nx][ny] = 2
        q.append((nx, ny))

if 2 in board[-1]: print('YES')
else: print('NO')