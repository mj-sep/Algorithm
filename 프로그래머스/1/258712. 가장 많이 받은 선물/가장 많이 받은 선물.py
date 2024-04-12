def solution(friends, gifts):

    arr = [[0 for _ in range(len(friends))] for _ in range(len(friends))]
    nm_arr = [0 for _ in range(len(friends))]
    gift_ = [0 for _ in range(len(friends))]
    
    # 2차원 배열로 선물 주고받은 내역 정리
    for items in gifts:
        x, y = map(str, items.split())
        x_idx = friends.index(x)
        y_idx = friends.index(y)
        arr[x_idx][y_idx] += 1        
    
    
    # 선물 지수 계산
    for i in range(len(friends)):
        sum_ = sum(arr[i])
        for j in range(len(friends)):
            sum_ -= arr[j][i]
        gift_[i] = sum_
    
    # 다음 달 선물현황 계산
    for i in range(len(friends)):
        for j in range(i+1, len(friends)):
            if arr[i][j] == arr[j][i] and gift_[i] != gift_[j]:
                gh = i if gift_[i] > gift_[j] else j
                gl = i if gift_[i] < gift_[j] else j
                nm_arr[gh] += 1
            elif arr[i][j] == arr[j][i] and gift_[i] == gift_[j]:
                continue
            else:
                gh = i if arr[i][j] > arr[j][i] else j
                gl = i if arr[i][j] < arr[j][i] else j
                nm_arr[gh] += 1
    
                      
    return max(nm_arr)