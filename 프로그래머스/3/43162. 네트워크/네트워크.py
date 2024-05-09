def solution(n, computers):
    answer = 0
    net = dict()
    visited = [0 for _ in range(n)]
    
    # dict() 형변환
    for i in range(n):
        for j in range(n):
            if i == j or computers[i][j] == 0: continue
            
            if i not in net:
                net[i] = [j]
            else:
                net[i].append(j)

    
    def dfs(v):
        if v in net:
            for item in net[v]:
                if visited[item] == 0:
                    visited[item] = 1
                    dfs(item)
        return


    for i in range(n):
        if visited[i] == 0:
            dfs(i)
            answer += 1

            
    return answer