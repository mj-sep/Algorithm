from collections import deque
import sys

sys.setrecursionlimit(10**6)

n = int(input())
board = []
min_ = 100
max_ = 0
result = 0


dx , dy = [-1, 0, 1, 0], [0, -1, 0, 1]

def dfs(sx, sy, visited, b):
    visited[sx][sy] = 1
    
    for i in range(len(dx)):
        nx, ny = sx + dx[i], sy + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        
        if visited[nx][ny] == 0 and b[nx][ny] != 0:
            dfs(nx, ny, visited, b)
    
    return


for _ in range(n):
    arr_list = list(map(int, input().split()))
    max_ = max(max(arr_list), max_)
    board.append(arr_list)
    
 # 각 경우의 수 모두 확인
for i in range(0, max_):
    q = deque()
    
    # 물 높이에 맞게 board 조작
    for x in range(n):
        for y in range(n):
            if board[x][y] <= i: board[x][y] = 0
            else:
                q.append((x, y))
                
    visited = [[0 for _ in range(n)] for _ in range(n)]
    sum_ = 0
    
    while q:
        sx, sy = q.popleft()
        if visited[sx][sy] != 0:
            continue
        else:
            dfs(sx, sy, visited, board)
            sum_ += 1
            
    result = max(result, sum_)
    
print(result)