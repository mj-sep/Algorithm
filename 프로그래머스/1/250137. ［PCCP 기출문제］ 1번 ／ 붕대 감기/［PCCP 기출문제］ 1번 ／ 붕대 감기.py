def solution(bandage, health, attacks):
    answer = health
    at_sec = [attacks[i][0] for i in range(len(attacks))]
    double = 0
    
    for i in range(1, attacks[-1][0]+1):
        if i in at_sec:
            double = 0
            idx = at_sec.index(i)
            answer -= attacks[idx][1]
        else:
            answer += bandage[1]
            double += 1
    
            if double == bandage[0]: 
                answer += bandage[2] 
                double = 0
                
            if answer > health:
                answer = health
                        
        if answer <= 0:
            answer = -1
            break
            

    return answer