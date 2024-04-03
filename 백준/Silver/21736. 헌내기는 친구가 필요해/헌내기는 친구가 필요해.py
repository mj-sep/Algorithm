from collections import deque

arr = []
q = deque()
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
n, m = map(int, input().split())
visited = [[0 for _ in range(m)] for _ in range(n)]
cnt = 0

for i in range(n):
    arr_list = list(input())
    for j in range(len(arr_list)):
        if arr_list[j] == 'I': 
            q.appendleft((i, j))
            visited[i][j] = 1
        if arr_list[j] == 'X': visited[i][j] = -1
    arr.append(arr_list)


    
while q:
    sx, sy = q.popleft()
    for i in range(len(dx)):
        nx, ny = sx + dx[i], sy + dy[i]
        
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if visited[nx][ny] != 0:
            continue
        if arr[nx][ny] == 'X':
            continue
        
        if arr[nx][ny] == 'P':
            cnt += 1    
        q.append((nx, ny))
        visited[nx][ny] = visited[sx][sy] + 1
    else:
        continue
    break

print(cnt if cnt > 0 else 'TT')