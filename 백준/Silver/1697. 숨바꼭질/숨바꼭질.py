from collections import deque

n, k = map(int, input().split())
max_num = max(n, k)
dx = [-1, 1, 0]
MAX = 100001
visited = [0 for _ in range(MAX)]

q = deque()
q.appendleft(n)

if n == k: print(0)
else:
    while q:
        now = q.popleft()
        for i in range(3):
            next = now + dx[i] if i < 2 else now*2

            # 예외 처리
            if next < 0 or next >= MAX:
                continue
            if visited[next] != 0:
                continue
            
            if next == k:
                print(visited[now] + 1)
                break
            
            visited[next] = visited[now] + 1
            q.append(next)
            
            
        else:
            continue
        break
