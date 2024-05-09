from collections import deque

def solution(maps):
    answer = -1
    q = deque()
    dx, dy = [-1, 0, 0, 1], [0, -1, 1, 0]
    
    n, m = len(maps), len(maps[0])
    visited = [[0 for _ in range(m)] for _ in range(n)]
    q.append((0, 0))
    visited[0][0] = 1
    
    # bfs
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m: # 맵 벗어남
                continue
            if visited[nx][ny] != 0: # 이미 방문한 자리
                continue
            if maps[nx][ny] == 0:  # 벽이 있는 자리
                continue
                
            visited[nx][ny] = visited[x][y] + 1
            if nx == n-1 and ny == m-1: # 도착
                answer = visited[nx][ny]
                q.clear()
                break
            else:
                q.append((nx, ny))
        
    return answer