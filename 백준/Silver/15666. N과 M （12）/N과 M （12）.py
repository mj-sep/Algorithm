n, m = map(int, input().split())
arr = list(set(list(map(int, input().split()))))
arr.sort()

def back(v, cnt):
    global result
    if cnt == 0:
        print(" ".join(map(str, result)))
        return
    
    for item in arr:
        if item < v:
            continue
        
        result.append(item)
        back(item, cnt-1)
        result.pop()
    
result = []
back(0, m)