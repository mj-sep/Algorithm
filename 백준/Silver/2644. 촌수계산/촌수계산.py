from collections import deque

n = int(input()) # 인원수 
x, y = map(int, input().split()) # 시작점, 도착점
m = int(input())

graph = [[] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]

# 연결 노드 리스트화
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(v, cnt):
    global check
    cnt += 1
    visited[v] = 1
    
    if v == y:
        print(cnt-1)
        check = True
        
    for i in graph[v]:
        if visited[i] == 0:
            dfs(i, cnt)


check = False      
dfs(x, 0)
if not check: print(-1)
            