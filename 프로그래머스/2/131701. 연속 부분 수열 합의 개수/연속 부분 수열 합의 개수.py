def solution(elements):
    answer_set = set()
    
    # i -> 길이 / j -> 시작점
    for i in range(1, len(elements)+1):
        sum_ = 0
        for j in range(len(elements)):
            if j + i >= len(elements):
                idx = j + i - len(elements)
                sum_ = sum(elements[j:]) + sum(elements[0:idx])
            else:
                sum_ = sum(elements[j:j+i])
            answer_set.add(sum_)
                
    return len(answer_set)