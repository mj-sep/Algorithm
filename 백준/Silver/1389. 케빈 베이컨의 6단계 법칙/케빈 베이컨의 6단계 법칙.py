# 1389 
from collections import deque

n, m = map(int, input().split())
kb = dict()

for _ in range(m):
    x, y = map(int, input().split())
    if x in kb:
        kb[x].append(y)
    else:
        kb[x] = [y]
    
    if y in kb:
        kb[y].append(x)
    else:
        kb[y] = [x]
    
def bfs(q, v, j):
    while q:
        x = q.popleft()
        for item in kb[x]:
            if v[item] != 0: continue
            if item == j:
                kevin_sub.append(v[x] + 1)
                return
            v[item] = v[x] + 1
            q.append(item)
    return


kevin = [0 for _ in range(n+1)]
for i in range(1, n+1):
    kevin_sub = []
    for j in range(1, n+1):
        if i == j: continue
        q = deque()
        q.appendleft(i)
        visited = [0 for _ in range(n+1)]
        bfs(q, visited, j)
        # print('[->]', i, j, kevin_sub)
    kevin[i] = sum(kevin_sub)
    # print(kevin_sub)
    
min_ = kevin[1]
min_idx = 1
for i in range(1, len(kevin)):
    if kevin[i] < min_:
        min_ = kevin[i]
        min_idx = i

print(min_idx)
        