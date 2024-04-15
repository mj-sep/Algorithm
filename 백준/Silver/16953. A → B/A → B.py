a, b = map(int, input().split())
min_ = 10 ** 9 - 1

# 백트래킹
def back(x, y, cnt):
    global min_
    if y < x: 
        min_ = -1
        return
    if x == y:
        min_ = min(cnt+1, min_)
        return
    
    last_digit = int(str(y)[-1])
    if last_digit == 1:
        stry = str(y)
        back(x, int(stry[:len(stry)-1]), cnt+1)
    if y % 2 == 0:
        back(x, y//2, cnt+1)

back(a, b, 0)
if min_ == 10 ** 9 - 1: min_ = -1
print(min_)