# 11052

n = int(input())
card = [0] + list(map(int, input().split()))

d = [-1 for _ in range(n+1)] # dp
d[0] = 0
d[1] = card[1]

if n > 1:
    d[2] = max(d[1] + d[1], card[2])
    
for i in range(1, n+1):
    for k in range(1, i+1):
        d[i] = max(d[i], d[i-k] + card[k])

print(d[n])
