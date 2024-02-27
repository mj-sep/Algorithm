from collections import deque

n, m = map(int, input().split())
arr = list(map(int, input().split()))
d = deque([i for i in range(1, n+1)])
result = 0

for data in arr:
    while 1:
        if d[0] == data:
            d.popleft()
            break
        else:
            if d.index(data) < len(d)/2: # 왼/오 가까운 쪽 찾기
                while d[0] != data:
                    d.append(d.popleft())
                    result += 1
            else:
                while d[0] != data:
                    d.appendleft(d.pop())
                    result += 1

print(result)
