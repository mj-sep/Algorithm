
def solution(citations):
    answer = 0
    citations.sort()
    mark = len(citations)
    
    if len(citations) == 1:
        answer = 0
    else:
        while True:
            up_to_mark = 0
            down_to_mark = 0
            for j in range(len(citations)):
                if citations[j] >= mark: 
                    up_to_mark += 1
                elif citations[j] < mark:
                    down_to_mark += 1
                
            if up_to_mark >= mark and down_to_mark <= mark:
                answer = mark
                break
            else:
                mark -= 1
                
    
    return answer