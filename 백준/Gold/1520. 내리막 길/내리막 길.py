# 1520
# (DFS) 13% 시간 초과
# (DP + DFS)로 수정

m, n = map(int, input().split())
board = []
d = [[-1 for _ in range(n)] for _ in range(m)]
d[0][0] = 0

for _ in range(m):
    arr = list(map(int, input().split()))
    board.append(arr)

dx, dy = [1, 0, -1, 0], [0, -1, 0, 1]
gx, gy = m-1, n-1

def dfs(x, y):
    global cnt
    if x == gx and y == gy:
        return 1
    
    result = 0
    for i in range(len(dx)):
        nx, ny = x + dx[i], y + dy[i]
        # 예외 처리
        if nx < 0 or ny < 0 or nx >= m or ny >= n:
            continue
        if board[nx][ny] >= board[x][y]:
            continue
        
        # 이미 DP에서 구했던 값이라면?
        if d[nx][ny] >= 0:
            result += d[nx][ny]
        else:
            result += dfs(nx, ny)
            
    d[x][y] = result
    return result
        
            
print(dfs(0, 0))