# 1189
r, c, k = map(int, input().split())
board = []
dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1]
visited = [[0 for _ in range(c)] for _ in range(r)]

for _ in range(r):
    arr = list(input())
    board.append(arr)
    
    
def dfs(x, y, cnt):
    global answer
    if cnt == k:
        if x == 0 and y == c-1: 
            answer += 1
        else: return
        
    for i in range(len(dx)):
        nx, ny = x + dx[i], y + dy[i]
        if nx < 0 or ny < 0 or nx >= r or ny >= c:
            continue
        if board[nx][ny] == 'T':
            continue
        
        if visited[nx][ny] == 0:
            visited[nx][ny] = 1
            dfs(nx, ny, cnt + 1)
            visited[nx][ny] = 0
    return
  
answer = 0
visited[r-1][0] = 1
dfs(r-1, 0, 1)
print(answer)