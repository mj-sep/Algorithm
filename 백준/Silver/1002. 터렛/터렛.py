# 1002
t = int(input())

for _ in range(t):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    cnt = 0
    
    d = ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5
    
    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)
    elif r1 + r2 == d or abs(r1 - r2) == d: # 내접 / 외접 -> 만나는 점 1개
        print(1)
    elif r1 + r2 > d and abs(r1 - r2) < d:
        print(2)
    else:
        print(0)
        