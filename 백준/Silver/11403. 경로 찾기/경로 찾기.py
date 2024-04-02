import sys

sys.setrecursionlimit(10**6)

n = int(input())
g = dict()
graph = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    arr_list = list(map(int, input().split()))
    for j in range(n):
        if arr_list[j] == 1:
            if i+1 in g:
                g[i+1].append(j+1)
            else:
                g[i+1] = [j+1]


def dfs(s, d, cnt):
    cnt += 1
    visited[s] = 1
    
    if cnt > n+1: # 무한반복 걸리지 않게 조치
        return False
    if s == d and cnt != 1:
        return True
    
    if s in g:
        if g[s]:
            for data in g[s]:
                if visited[data] != 0 and data != d: # 방문했던 노드를 다시 방문하지 않도록 조치 (목적지인 경우 제외)
                    continue
                
                if dfs(data, d, cnt):
                    return True
        else: return False
    else: return False
            
            
for i in range(n):
    for j in range(n):
        visited = [0 for _ in range(n+1)]
        if graph[i][j] == 0:
            if dfs(i+1, j+1, 0): graph[i][j] = 1

for rows in graph:
    for item in rows:
        print(item, end=' ')
    print()