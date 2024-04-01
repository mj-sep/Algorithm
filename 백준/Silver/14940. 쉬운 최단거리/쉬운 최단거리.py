from collections import deque

n, m = map(int, input().split())
arr = []
visited = [[-1 for _ in range(m)] for _ in range(n)]
dest = [0, 0]
dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1]
q = deque()
q_zero = deque()

for i in range(n):
    arr_list = list(map(int, input().split()))
    for j in range(len(arr_list)):
        if arr_list[j] == 2: 
            q.appendleft((j, i))
        elif arr_list[j] == 0:
            q_zero.append((j, i))
    arr.append(arr_list)
    
x, y = q.popleft()
q.appendleft((x,y))
visited[y][x] = 0

# 2가 있는 위치에서부터 모든 좌표로 bfs
while q:
    sx, sy = q.popleft()
    for i in range(len(dx)):
        nx, ny = sx + dx[i], sy + dy[i]
        
        if nx < 0 or ny < 0 or nx >= m or ny >= n:
            continue
        if visited[ny][nx] != -1:
            continue
        
        if arr[ny][nx] == 0:
            visited[ny][nx] = 0
        else:
            visited[ny][nx] = visited[sy][sx] + 1
            q.append((nx, ny))
    else:
        continue
    
while q_zero:
    x, y = q_zero.popleft()
    visited[y][x] = 0
    
for item in visited:
    for data in item:
        print(data, end=' ')
    print()