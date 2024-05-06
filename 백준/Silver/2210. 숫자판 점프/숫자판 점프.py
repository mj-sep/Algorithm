# 2210

board = []
data = []
dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1]

for _ in range(5):
    arr = list(map(int, input().split()))
    board.append(arr)
    

def dfs(x, y, s, cnt):
    if cnt == 6:
        if s not in data:
            data.append(s)
        return
            
    for i in range(len(dx)):
        nx, ny = x + dx[i], y + dy[i]
        
        if nx < 0 or ny < 0 or nx >= 5 or ny >= 5:
            continue
        dfs(nx, ny, s + str(board[nx][ny]), cnt + 1)
        

for i in range(5):
    for j in range(5):
        dfs(i, j, str(board[i][j]), 1)
    
print(len(data))