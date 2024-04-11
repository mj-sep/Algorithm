from collections import deque
import copy

def solution(s):
    answer = 0
    
    q = deque()
    open_ = ['[', '{', '(']
    close_ = [']', '}', ')']
    
    for item in s:
        q.append(item)
    
    if len(s) > 1:
        for i in range(len(s)):
            qcopy = copy.deepcopy(q)
            for j in range(i):
                qcopy.append(qcopy.popleft())

            front = qcopy.popleft()
            back = qcopy.pop()
            qcopy.append(back)
            qcopy.appendleft(front)

            if front in close_:
                continue
            elif back in open_:
                continue
            else:
                stack = []
                stack.append(qcopy.popleft())

                for x in range(len(s)):

                    if not qcopy:
                        continue    

                    q_pop = qcopy.popleft()
                    if not stack:
                        stack.append(q_pop)
                        continue

                    if stack[-1] in open_ and q_pop in close_:
                        if stack[-1] == '[' and q_pop == ']':
                            stack.pop()
                        elif stack[-1] == '(' and q_pop == ')':
                            stack.pop()
                        elif stack[-1] == '{' and q_pop == '}':
                            stack.pop()
                        else:
                            break
                    else:
                        stack.append(q_pop)
            
            if not stack: answer += 1    
                        
                
    return answer