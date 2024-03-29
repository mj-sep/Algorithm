from collections import deque

n = int(input())
arr = []
paperlist = deque()
result = [0, 0]

for _ in range(n):
    arr_list = list(map(int, input().split()))
    arr.append(arr_list)
    
def paper(x, y, diff):
    color = [0, 0]
    for i in range(x, x + diff):
        for j in range(y, y + diff):
            if arr[i][j] == 0:
                color[0] += 1
            else: color[1] += 1
            
    diff = diff//2
    if color[0] == 0: result[0] += 1
    elif color[1] == 0: result[1] += 1
    else: 
        paperlist.appendleft((x, y, diff))
        paperlist.appendleft((x+diff, y, diff))
        paperlist.appendleft((x, y+diff, diff))
        paperlist.appendleft((x+diff, y+diff, diff))

paperlist.append((0, 0, n)) 
while paperlist:
    x, y, diff = paperlist.popleft()
    paper(x, y, diff)
        
print(result[1])
print(result[0])