import sys

# recursion error 해결 방안으로 limit 늘려줌 - Pypy3에서는 오류
sys.setrecursionlimit(10 ** 9)

n = int(input())
tree = [[] for _ in range(n+1)]
visited = [0] * (n+1)

for _ in range(n-1):
    x, y = map(int, input().split())
    tree[x].append(y)
    tree[y].append(x)
    
def dfs(v):
    for i in tree[v]:
        if not visited[i]:
            visited[i] = v
            dfs(i)
            
dfs(1)
for i in range(2, n+1):
    print(visited[i])