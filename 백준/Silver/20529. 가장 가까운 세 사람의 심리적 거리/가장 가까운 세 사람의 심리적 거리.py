from itertools import combinations

t = int(input())

def calculate(arr):
    sum_ = 0
    
    # 세 유형의 거리 계산
    for i in range(len(arr)):
        nx_list = arr[i+1] if i < len(arr)-1 else arr[0]
        compare_list = [x for x in arr[i] if x not in nx_list]
        sum_ += len(compare_list)
    return sum_    
    
for _ in range(t):
    arr = []
    n = int(input())
    arr_dict = dict()
    arr_list = list(map(str, input().split()))
    for item in arr_list:
        arr.append((list(item)))
        arr_dict[item] = 1 if item not in arr_dict else arr_dict[item] + 1
    
    ad_values = list(arr_dict.values())
    ad_values_up_to_three = [x for x in ad_values if x > 2]
    
    if n == 3: # 3명만 주어졌을 경우
        print(calculate(arr))
    elif ad_values_up_to_three: # 인원 수 상관없이 3개 이상인 MBTI가 있을 경우
        print(0)
    else: # 나머지...는 조합으로...
        comb = list(combinations(arr_list, 3))
        min_ = 100000
        for item in comb:
            min_ = min(calculate(item), min_)
        print(min_)