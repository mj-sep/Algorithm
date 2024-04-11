import sys
import heapq

# 입력 받기
N = int(input())
M = int(input())
graph = [[] for i in range(N+1)]

for _ in range(M):
    x, y, cost = map(int, sys.stdin.readline().split())
    graph[x].append([y, cost])
          
s, d = map(int, sys.stdin.readline().split()) # 출발, 도착지
costs = [1e9 for _ in range(N+1)]
heap = []
costs[s] = 0
heapq.heappush(heap, [0, s])

while heap:
    cc, cv = heapq.heappop(heap)
    if costs[cv] < cc:
        continue
    for nv, nc in graph[cv]:
        sum_cost = cc + nc
        if sum_cost >= costs[nv]:
            continue
        costs[nv] = sum_cost
        heapq.heappush(heap, [sum_cost, nv])
        
        
print(costs[d])


# 메모리 초과 문제
# (1) 방문 노드 삭제 -> 여전히 메모리 초과
# (2) dfs 반환값 담던 리스트 삭제하고 즉각적으로 최소값 반영 -> 여전히 메모리 초과
# (3) dict()형 list()로 수정 -> 메모리 초과...
# (4) 입력값의 범위가 너무 넓어서 메모리 초과 발생하는 걸로 추정 -> 다익스트라로 알고리즘 변경 -> 시간 초과
# (5) ㅎㅎ... sys.redline으로 입력 받도록 수정