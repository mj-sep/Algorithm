n = int(input())
m = int(input())
s = input()

p_str = 'IOI'
for _ in range(n-1):
    p_str += 'OI'

cnt = 0
for i in range(0, m-len(p_str)+1):
    split_str = s[i:i+len(p_str)]
    if split_str == p_str: 
        cnt += 1
    
print(cnt)