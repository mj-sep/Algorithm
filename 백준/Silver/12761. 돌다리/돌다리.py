# 12761
from collections import deque

a, b, n, m = map(int, input().split())
visited = [0 for _ in range(1000001)]
q = deque()
d = [-1, 1, -1*a, a, -1*b, b, a, b]
q.appendleft(n)

while q:
    x = q.popleft()
    for i in range(len(d)):
        if i == 6: nx = x * a
        elif i == 7: nx = x * b
        else: nx = x + d[i]
        
        if nx < 0 or nx > 100000:
            continue
        if visited[nx] != 0:
            continue
        
        visited[nx] = visited[x] + 1
        if nx == m:
            q.clear()
            print(visited[nx])
        else: q.append(nx)
    
