
n = int(input())
d = [0] * 10001
arr = list(int(input()) for _ in range(n))

d[0] = arr[0]
d[1] = arr[0] + arr[1] if len(arr) > 1 else 0
d[2] = max(arr[2]+arr[0], arr[2]+arr[1], d[1]) if len(arr) > 2 else 0

if n > 2:
    for i in range(3, n):
        d[i] = max(arr[i] + d[i-2], arr[i] + d[i-3] + arr[i-1], d[i-1])

print(d[n-1])