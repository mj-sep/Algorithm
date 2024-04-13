def solution(board, h, w):
    answer = 0
    dh, dw = [0, 1, -1, 0], [1, 0, 0, -1]
    color = board[h][w]
    
    for i in range(len(dh)):
        nx, ny = h+dh[i], w+dw[i]
        if nx < 0 or ny < 0 or nx >= len(board) or ny >= len(board):
            continue
        
        if board[nx][ny] == color: answer += 1
        
    return answer