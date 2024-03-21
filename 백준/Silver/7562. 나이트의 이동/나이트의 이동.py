from collections import deque

dx, dy = [-2, -1, 1, 2, -2, -1, 1, 2], [1, 2, 2, 1, -1, -2, -2, -1]

tc = int(input())
for i in range(tc):
    l = int(input())
    arr = [[i for i in range(l)] for i in range(l)]
    sx, sy = map(int, input().split())
    ax, ay = map(int, input().split())
    breakcheck = False

    if sx == ax and sy == ay:
        print(0)
    else:
        visited = [[0 for _ in range(l)] for _ in range(l)]
        q = deque()
        q.append((sx, sy))

        while q:            
            sx, sy = q.popleft()
            
            for i in range(len(dx)):
                nx, ny = sx + dx[i], sy + dy[i]

                # 이동 불가능하거나 문제 생기는 부분 정의
                if nx < 0 or ny < 0 or nx >= l or ny >= l: # 인덱스 범위 초과
                    continue
                if visited[nx][ny] != 0: # 이미 방문한 노드
                    continue
            
                if nx == ax and ny == ay: # 도착
                    print(visited[sx][sy] + 1)
                    break
                else:
                    visited[nx][ny] = visited[sx][sy] + 1
                    q.append((nx, ny))
            
            else:
                continue
            break
