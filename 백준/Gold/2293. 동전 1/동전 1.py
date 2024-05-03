# 2293
n, k = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))
    
dp = [0 for _ in range(k+1)]
dp[0] = 1

for item in arr:
    for i in range(item, k+1):
        dp[i] += dp[i-item]
        
print(dp[k])