import copy

def solution(want, number, discount):
    
    length = sum(number)
    answer = 0

    # 사전 형태로 want 데이터 변경
    want_data = dict()
    for i in range(len(want)):
        want_data[want[i]] = number[i]
    
    day = 0
    while True:
        wdcy = copy.deepcopy(want_data)
        if day > len(discount) - length: break
        for i in range(day, day + length):
            if i >= len(discount): continue
            
            if discount[i] in wdcy:
                wdcy[discount[i]] -= 1
                if wdcy[discount[i]] < 0: break
            else:
                break
                
        alldiscount = True
        for item in wdcy:
            if wdcy[item] != 0:
                alldiscount = False
                break
        
        answer = answer + 1 if alldiscount else answer
        day += 1
    
            
        
    return answer