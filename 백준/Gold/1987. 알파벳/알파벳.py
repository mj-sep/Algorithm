# 1987 87% 
r, c = map(int, input().split())
board = []
dx, dy = [-1, 0, 1, 0], [0, 1, 0, -1]

for _ in range(r):
    arr = list(input())
    board.append(arr)
    

def dfs(x, y, str):
    global max_
    for i in range(len(dx)):
        nx, ny = x + dx[i], y +dy[i]
        if nx < 0 or ny < 0 or nx >= c or ny >= r:
            continue
        if board[ny][nx] in str:
            continue
        max_ = max(max_, len(str) + 1)
        dfs(nx, ny, str+board[ny][nx])
    return

max_ = 1
dfs(0, 0, board[0][0])
print(max_)
