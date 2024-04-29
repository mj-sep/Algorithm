'''
17298
# 38% 시간초과
'''

import sys
n = int(input())
arr = list(map(int, sys.stdin.readline().split()))
answer = [-1] * n
stack = []

for i in range(len(arr)):
    while stack and arr[i] > arr[stack[-1]]:
        answer[stack[-1]] = arr[i]
        stack.pop()
    stack.append(i)

print(*answer)