from collections import deque

n, r, c = map(int, input().split())
cnt = 0
youknowanswer = False
q = deque()
            
def recursion(x, y, diff, cnt_sub):
    global cnt
    if diff > 2:
        if x <= r < x+diff and y <= c < y+diff:  
            diff_sub = diff//2
            q.appendleft((x+diff_sub, y+diff_sub, diff_sub))
            q.appendleft((x+diff_sub, y, diff_sub))
            q.appendleft((x, y+diff_sub, diff_sub))
            q.appendleft((x, y, diff_sub))
        else:
            cnt += (diff*diff)
    else:
        for i in range(x, x+diff):
            for j in range(y, y+diff):
                if i == r and j == c: 
                    print(cnt)
                    youknowanswer == True
                    break 
                cnt += 1
            else:
                continue
            break
    
q.appendleft((0, 0, (2**n)//2))
q.append((0, (2**n)//2, (2**n)//2))
q.append(((2**n)//2, 0, (2**n)//2))
q.append(((2**n)//2, (2**n)//2, (2**n)//2))

if n == 1 and r == 0 and c == 0:
    print(0)
else:
    while q:
        x, y, diff = q.popleft()
        recursion(x, y, diff, cnt)
        if youknowanswer: break