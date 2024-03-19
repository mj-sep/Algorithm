# 1018. 체스판 다시 칠하기

n, m = map(int, input().split())
chess = []
value = []

for _ in range(n):
    arr = list(input())
    chess.append(arr)

for i in range(n-7):
    for j in range(m-7):
        bl = 0
        wh = 0

        for x in range(i, i+8):
            for y in range(j, j+8):
                if (x + y) % 2 == 0:
                    if chess[x][y] != 'B':
                        bl += 1
                    else:
                        wh += 1
                else:
                    if chess[x][y] != 'W':
                        bl += 1
                    else:
                        wh += 1

        value.append(bl)
        value.append(wh)
print(min(value))