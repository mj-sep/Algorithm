from collections import deque
import sys

sys.setrecursionlimit(10**6)

dx, dy = [-1, 0, 0, 1, -1, -1, 1, 1], [0, -1, 1, 0, -1, 1, -1, 1]

def dfs(sx, sy, visited):
    visited[sy][sx] = 1
    for i in range(len(dx)):
        nx, ny = sx + dx[i], sy + dy[i]
        if nx < 0 or ny < 0 or nx >= w or ny >= h:
            continue
        
        if visited[ny][nx] == 0 and board[ny][nx] == 1:
            visited[ny][nx] = 1
            dfs(nx, ny, visited)
    return 

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    else:
        board = []
        q = deque()
        visited = [[0 for _ in range(w)] for _ in range(h)]
        
        for i in range(h):
            arr_list = list(map(int, input().split()))
            for j in range(len(arr_list)):
                if arr_list[j] == 1:
                    q.append((j, i))
            board.append(arr_list)
        
        sum_ = 0
        while q:
            sx, sy = q.popleft()
            if visited[sy][sx] != 0:
                continue
            else: 
                dfs(sx, sy, visited)
                sum_ += 1
            
        print(sum_)
        