
# 1699
n = int(input())
d = [0] * (n+1)

d[0] = 0
d[1] = 1
if n > 1: d[2] = 2
if n > 2: d[3] = 3

def dp(x):
    if d[x] != 0: return d[x]
    
    calc = int(x**0.5) # 가장 최근 제곱근
    if calc ** 2 == x: # 의 제곱수와 같다면 무조건 1
        d[x] = 1
    else: 
        min_ = n
        for i in range(calc, 0, -1): # 0이 아니라면 제곱수의 경우(1) + 차이값으로 dp 돌리기
            calc2 = x - i ** 2
            calc3 = 1 + dp(calc2) 
            min_ = min(min_, calc3)
        d[x] = min_
        
    return d[x]

print(dp(n))
    

