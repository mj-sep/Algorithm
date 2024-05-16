# 2529

k = int(input())
ms = list(input().split())
num = [str(i) for i in range(10)]

min_ = 1e10
max_ = 0

def back(s, idx):
    global min_
    global max_

    if len(s) > k:
        min_ = min(int(s), min_)
        max_ = max(int(s), max_)
        return
    
    for i in range(len(num)):
        if num[i] in s: continue
        
        if idx == 0:
            s += num[i]
        else:
            if ms[idx-1] == '>' and int(s[-1]) > int(num[i]):
                s += num[i]
            elif ms[idx-1] == '<' and int(s[-1]) < int(num[i]):
                s += num[i]
            else: 
                continue
        
        back(s, idx+1)
        s = s[:-1]
               
back('', 0)

if len(str(max_)) > k:
    print(max_)
else:
    print('0' + str(max_))
    
if len(str(min_)) > k:
    print(min_)
else:
    print('0' + str(min_))
