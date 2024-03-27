from collections import deque

m, n, k = map(int, input().split())
rect = [[0 for _ in range(n)] for _ in range(m)]
dx, dy = [0, 0, -1, 1], [-1, 1, 0, 0]
answer = []

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(x1, x2):
        for j in range(y1, y2):
            rect[j][i] = 1
            
def bfs(x, y):
    q = deque()
    q.append((x,y))
    rect[x][y] = 1
    size = 1
    while q:
        sx, sy = q.popleft()
        for i in range(len(dx)):
            nx, ny = sx + dx[i], sy + dy[i]
            
            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            if rect[nx][ny] != 0:
                continue
            
            rect[nx][ny] = 1
            q.append((nx, ny))
            size += 1
    answer.append(size)


for i in range(n):
    for j in range(m):
        if rect[j][i] == 0:
            bfs(j,i)
        

answer.sort()
print(len(answer))
for item in answer:
    print(item, end=' ')