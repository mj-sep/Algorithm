# 1759. 암호 만들기

l, c = map(int, input().split())
arr_c = list(input().split())
arr_c.sort()

# 모음/자음 최소 개수 충족여부 확인
def check(pw):
    cnt_c = 0
    cnt_v = 0

    for i in pw:
        if i in ['a', 'e', 'i', 'o', 'u']:
            cnt_v += 1
        else:
            cnt_c += 1

    if cnt_v >= 1 and cnt_c >= 2: return True
    else: return False

# 백트래킹    
def backtr(arr):
    if len(arr) == l:
        if check(arr):
            print(''.join(arr))
            return
    for i in range(len(arr), c):
        if arr[-1] < arr_c[i]:
            arr.append(arr_c[i])
            backtr(arr)
            arr.pop()

for i in range(c-l+1):
    a = [arr_c[i]]
    backtr(a)