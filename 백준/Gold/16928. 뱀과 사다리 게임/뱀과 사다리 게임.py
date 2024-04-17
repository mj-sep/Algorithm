# 16928 (8%)
from collections import deque

n, m = map(int, input().split())

arr = [i for i in range(101)]
visited = [0 for _ in range(101)]

for _ in range(n):
    x, y = map(int, input().split())
    arr[x] = y

for _ in range(m):
    u, v = map(int, input().split())
    arr[u] = v
    
q = deque()
q.append(1)
visited[1] = 0
dice = [1, 2, 3, 4, 5, 6]

while q:
    x = q.popleft()
    
    for item in dice:
        nx = x + item
        
        if nx >= 100: # 달성
            print(visited[x] + 1)
            break
        
        if visited[nx] != 0:
            continue
        
        q.append(arr[nx])
        if nx != arr[nx]: # 뱀 or 사다리
            visited[nx] = visited[x] + 1
            min_ = min(visited[x]+1, visited[arr[nx]]) if visited[arr[nx]] > 0 else visited[x] + 1
            visited[arr[nx]] = min_
            
            if arr[nx] == 100: # 뱀/사 타고 100 도달한 경우
                print(visited[arr[nx]])
                break
        else: 
            visited[arr[nx]] = visited[x] + 1
        
    else:
        continue
    break

""" 방문 확인용 주석
for i in range(1, 101, 10):
    print(visited[i:i+10])
"""

        
