# 1946
import sys

t = int(sys.stdin.readline())
for _ in range(t):
    cnt = 1
    result = dict()
    n = int(sys.stdin.readline())
    for _ in range(n):
        s1, s2 = map(int, sys.stdin.readline().split())
        result[s1] = s2

    result = sorted(result.items())
    min_ = result[0][1]

    for x, y in result:
        if min_ > y:
            min_ = y
            cnt += 1
            
    print(cnt)
        