# 1068 77%
from collections import deque

n = int(input())
tree = dict()
arr = list(map(int, input().split()))
num = int(input()) # 지울 노드의 번호
q = deque() # 루트 노드가 2개 이상일 경우 대비

for i in range(n):
    tree[i] = []

for i in range(len(arr)):
    if arr[i] != -1:
        tree[arr[i]].append(i)
    else:
        q.appendleft(i)

def dfs(v):
    global cnt
    
    if v == num:
        return
    
    if tree[v]:
        status = False # 삭제 노드가 전체 단말 노드의 개수에 변화를 주는 경우인지 확인
        for item in tree[v]:
            if item != num:
                status = True
                dfs(item)
        if not status: cnt += 1
    else: 
        cnt += 1
        
cnt = 0
while q:
    v = q.popleft()
    dfs(v)


print(cnt)