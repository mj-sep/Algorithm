# 5014 (30%)

from collections import deque
f, s, g, u, d = map(int, input().split())
ev = [u, d*-1]
visited = [-1 for _ in range(f+1)]

q = deque()
q.append(s)
visited[s] = 0
status = False

if s == g: 
    print(0)
    status = True
else:
    while q:
        now = q.popleft()
        for i in range(len(ev)):
            next = now + ev[i]
            if next < 1 or next > f:
                continue
            
            if visited[next] != -1:
                continue
            
            if next == g:
                print(visited[now] + 1)
                status = True
                q.clear()
                break
            else:
                visited[next] = visited[now] + 1
                q.append(next)
        else: continue
        
            
if status == False: print("use the stairs")