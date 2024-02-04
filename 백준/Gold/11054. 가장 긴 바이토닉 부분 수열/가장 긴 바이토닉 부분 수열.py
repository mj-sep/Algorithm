n = int(input())
arr = list(map(int, input().split()))

increase = [1 for _ in range(n)] # 가장 긴 증가-부분수열
decrease = [1 for _ in range(n)] # 가장 긴 감소-부분수열

for i in range(n):
    for j in range(i):
        if arr[i] > arr[j]:
            increase[i] = max(increase[i], increase[j]+1)

for i in range(n-1, -1, -1):
    for j in range(n-1, i, -1):
        if arr[i] > arr[j]:
            decrease[i] = max(decrease[i], decrease[j]+1)

answer = [0 for _ in range(n)]
# 각 인덱스의 증가수열 + 감소수열 길이ㅢ 합 
for i in range(n):
    answer[i] = increase[i] + decrease[i] - 1

print(max(answer))