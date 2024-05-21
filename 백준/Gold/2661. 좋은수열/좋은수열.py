# 2661
n = int(input())

def back(cnt, num):
    # 현재 자릿수까지 좋은/나쁜 검사
    idx = cnt // 2
    for i in range(cnt-1, idx-1, -1):
        diff = cnt - i
        if i-diff < 0: continue
        
        if num[i:cnt] == num[i-diff:i]: # 나쁜 수열
            return
            
    if cnt == n:
        print(num)
        exit(0)
    
    for i in range(1, 4):
        back(cnt + 1, num + str(i))
        
    
back(0, '')