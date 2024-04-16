n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))
visited = [0 for _ in range(len(arr))]
tmp = []

def dfs():
    if len(tmp) == m:
        print(*tmp)
        return
    
    duplicate = 0
    for i in range(len(arr)):
        if visited[i] == 0 and duplicate != arr[i]:
            visited[i] = 1
            tmp.append(arr[i])
            duplicate = arr[i]
            dfs()
            visited[i] = 0
            tmp.pop()
    
    return
    
dfs()