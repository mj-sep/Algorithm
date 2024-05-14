# 6593
from collections import deque

while True:
    l, r, c = map(int, input().split())
    if l == 0 and r == 0 and c == 0: break
    
    board = []
    visited = [[[-1 for _ in range(c)] for _ in range(r)] for _ in range(l)]
    end = [0, 0, 0]
    q = deque()

    for i in range(l):
        arr_ = []
        for j in range(r):
            arr = list(input())
            for k in range(len(arr)):
                if arr[k] == 'S':
                    q.append((k, j, i))
                    visited[i][j][k] = 0
                if arr[k] == 'E':
                    end[0], end[1], end[2] = k, j, i
            arr_.append(arr)
        board.append(arr_)
        input()
    
    dx, dy, dh = [1, -1, 0, 0, 0, 0], [0, 0, -1, 1, 0, 0], [0, 0, 0, 0, -1, 1]
  
    status = False # 도달여부 확인
    while q:
        x, y, h = q.popleft()
        for i in range(len(dx)):
           nx, ny, nh = x + dx[i], y + dy[i], h + dh[i]
           if nx < 0 or ny < 0 or nh < 0 or nx >= c or ny >= r or nh >= l:
               continue
           if visited[nh][ny][nx] != -1:
               continue
           if board[nh][ny][nx] == '#':
               continue
           
           visited[nh][ny][nx] = visited[h][y][x] + 1
           if nx == end[0] and ny == end[1] and nh == end[2]:
               print('Escaped in', visited[nh][ny][nx], 'minute(s).')
               status = True
               q.clear()
               break
           else:
               q.append((nx, ny, nh))
               
               
    if not status: print('Trapped!')