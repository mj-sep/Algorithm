# 9184
def w(a, b, c):
    global w_arr
    if a <= 0 or b <= 0 or c <= 0:
        w_arr[0][0][0] = 1
        return 1
        
    if a > 20 or b > 20 or c > 20:
        if w_arr[20][20][20] == 0:
            w_arr[20][20][20] = w(20, 20, 20)
        return w_arr[20][20][20]
    
    if a < b and b < c:
        if w_arr[a][b][c] > 0:
            return w_arr[a][b][c]
        else:
            w_arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
            return w_arr[a][b][c]
    
    if w_arr[a][b][c] == 0:
        w_arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return w_arr[a][b][c]
    
    
while True:
    a, b, c = map(int, input().split())
    if a == -1 and b == -1 and c == -1:
        break
    
    w_arr = [[[0 for _ in range(21)] for _ in range(21)] for _ in range(21)]
    print('w(', a, ', ', b, ', ', c, ') = ', sep = '', end='')
    print(w(a, b, c))
