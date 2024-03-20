from collections import deque

R, C = map(int, input().split())
visited = [[-1] * C for _ in range(R)]
dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1]
twmap = []
q = deque()

for _ in range(R):
    arr = list(input())
    twmap.append(arr)
    
for j in range(R):
    for i in range(C):
        if twmap[j][i] == '*': # 물
            q.appendleft((j, i))
        elif twmap[j][i] == 'S': # 고슴
            q.append((j, i))
            visited[j][i] = 0
            
while q:
    j, i = q.popleft()
    now = twmap[j][i]
    for k in range(4):
        next_y, next_x = j + dy[k], i + dx[k]
        
        if next_y < 0 or next_x < 0 or next_y >= R or next_x >= C: # 인덱스 범위 초과
            continue
        if visited[next_y][next_x] != -1: # 전에 방문한 곳
            continue
        if twmap[next_y][next_x] == '*' or twmap[next_y][next_x] == 'X': # 물 or 돌
            continue
        if now == '*' and twmap[next_y][next_x] == 'D': # 물 -> 비버 집
            continue
        
        if now == 'S': # 현재 고슴도치일 때
            if twmap[next_y][next_x] == 'D': # 다음 목적지가 비버 집이면 완료
                print(visited[j][i] + 1)
                break
            else:
                visited[next_y][next_x] = visited[j][i] + 1
                
        twmap[next_y][next_x] = now
        q.append((next_y, next_x))
        
    else:
        continue
    break
else:
    print("KAKTUS")