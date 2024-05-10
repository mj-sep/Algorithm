# 12904
# ABBA -> ABB -> BA -> B

prev = input()
aft = input()

while len(aft) > len(prev):
    # (1) 문자열의 뒤에서 A를 빼거나
    aft_last = aft[-1]
    aft = aft[:-1]

    # (2) 문자열의 뒤에서 B를 빼고 문자열을 뒤집기
    if aft_last == 'B': 
        aft =''.join(reversed(aft))
    
if aft == prev:
        print(1)
else:
    print(0)