# 3190
from collections import deque

n = int(input())
board = [[0 for _ in range(n)] for _ in range(n)]
k = int(input()) # 사과의 개수
for _ in range(k):
    x, y = map(int, input().split())
    board[x-1][y-1] = 1
l = int(input()) # 뱀의 방향 변환 정보
info = dict()
for _ in range(l):
    sec, dir = input().split()
    info[int(sec)] = dir

q = deque()
q.append((0, 0))
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
d_idx = 0 # 방향 정보
sec = 0

while q:
    x, y = q.popleft()
    nx, ny = x + dx[d_idx], y + dy[d_idx]
    sec += 1
    
    # 벽에 부딪히면 게임 끝
    if nx < 0 or ny < 0 or nx >= n or ny >= n:
        break
    
    # 자기자신의 몸에 부딪히면 게임 끝
    if (nx, ny) in q:
        break
    
    if board[ny][nx] == 1:
        board[ny][nx] = 0
        q.appendleft((x, y))
        q.appendleft((nx, ny))
    else:
        if q: 
            q.pop()
            q.appendleft((x, y))
        q.appendleft((nx, ny))
    
    if sec in info: # 회전 dict에 해당 초 존재할 시
        if info[sec] == 'D':
            d_idx = d_idx + 1 if d_idx < 3 else 0
        if info[sec] == 'L':
            d_idx = d_idx - 1 if d_idx > 0 else 3
        
print(sec)
