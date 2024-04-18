# 17413
# 체크값이 True라면 > 나올때까지는 걍 무시 -> > 나오면 체크값 False
# 체크값이 False라면, 인덱스 저장하고 < 나올때까지 진행
# (1) < 나온다면 저장 인덱스와 현재 인덱스 리버스 -> 체크값 True
# (2) 공백문자가 나온다면 저장 인덱스와 현재 인덱스 리버스
# (3) < '' 둘다 나오지 않고 문자열이 종료되면 -> 루프 밖에서 저장 인덱스부터 끝까지 리버스

s = list(input())
check = False
result = ''

idx = -1
for i in range(len(s)):
    if check == True:
        if s[i] == '>':
            check = False
        result += s[i]
    else:
        if idx == -1 and s[i] != ' ':
            if s[i] == '<':
                result += s[i]
                check = True
            else: idx = i
        else:
            if s[i] == '<':
                s_reverse = list(reversed(s[idx:i]))
                result += ''.join(s_reverse)
                result += '<'
                idx = -1
                check = True
            elif s[i] == ' ':
                s_reverse = list(reversed(s[idx:i]))
                result += ''.join(s_reverse)
                result += ' '
                idx = -1
    
    
if check == False and idx != -1:
    s_reverse = list(reversed(s[idx:]))
    result += ''.join(s_reverse)  
           
print(result)