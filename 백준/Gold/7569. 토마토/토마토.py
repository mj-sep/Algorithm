# 7569
from collections import deque

m, n, h = map(int, input().split())
visited = [[[-1 for _ in range(m)] for _ in range(n)] for _ in range(h)]
board = []
q = deque()
dx, dy, dz = [-1, 0, 1, 0, 0, 0], [0, -1, 0, 1, 0, 0], [0, 0, 0, 0, -1, 1]
cnt = -1
entire = m * n * h
status = False

for i in range(h): # z
    arr2 = [] 
    for j in range(n): # y
        arr = list(map(int, input().split()))
        for k in range(m): #x
            if arr[k] == 0: status = True
            elif arr[k] == 1: 
                q.append((k, j, i))
                visited[i][j][k] = 0
                entire -= 1
            elif arr[k] == -1: 
                visited[i][j][k] = -2
                entire -= 1
        arr2.append(arr)
    board.append(arr2)


if not status: print(0)
else:
    while q:
        x, y, z = q.popleft()
        for i in range(len(dx)):
            nx, ny, nz = x + dx[i], y + dy[i], z + dz[i]
            if nx < 0 or ny < 0 or nz < 0 or nx >= m or ny >= n or nz >= h:
                continue
            if visited[nz][ny][nx] != -1:
                continue
            
            entire -= 1
            visited[nz][ny][nx] = 0 if board[nz][ny][nx] == 1 else visited[z][y][x] + 1
       
            q.append((nx, ny, nz))
            cnt = max(cnt, visited[nz][ny][nx])
            
    
    if entire != 0: print(-1) # 모든 토마토를 돌지 못했다면
    else: print(cnt)
