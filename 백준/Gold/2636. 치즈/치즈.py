# 2636
from collections import deque
import copy
h, w = map(int, input().split())
board = []
cheese = []

# 상하좌우 끝부분의 좌표를 큐에 채우기
q = deque()
for i in range(h):
    q.append((i, 0))
    q.append((h-i-1, w-1))

for j in range(w):
    q.append((0, j))
    q.append((h-1, w-j-1))
    
cnt = 0
for _ in range(h):
    arr = list(map(int, input().split()))
    board.append(arr)
    for j in range(len(arr)):
        if arr[j] == 1: cnt += 1
    
cheese.append(cnt)
dx, dy = [-1, 0, 0, 1], [0, -1, 1, 0]

def bfs(q_dcopy):
    global edge
    while q_dcopy:
        x, y = q_dcopy.popleft()
        for i in range(len(dx)):
            nx, ny = x + dx[i], y + dy[i]
            
            if nx < 0 or ny < 0 or nx >= h or ny >= w:
                continue
            if visited[nx][ny] != 0:
                continue
            
            visited[nx][ny] = 1
            if board[nx][ny] == 1: # 가장자리의 1 개수 세기
                board[nx][ny] = 2
                edge += 1
            else: q_dcopy.append((nx, ny)) # 공기랑 닿지 않는 치즈는 큐에 넣지 않음 (bfs Xxx)

while cheese[-1] > 0: # 남아있는 치즈가 없을 때까지 bfs
    edge = 0
    q_dcopy = copy.deepcopy(q)
    visited = [[0 for _ in range(w)] for _ in range(h)]
    bfs(q_dcopy)
    cheese.append(cheese[-1] - edge)

print(len(cheese)-1)
print(cheese[-2])
