from math import gcd

def solution(arr):
    lcd = arr[0]
    
    # 2개씩 뽑아서 최소공배수 구하기
    # a, b lcd = (a*b) / gcd(a,b)
    for i in range(1, len(arr)):
        lcd = (lcd*arr[i]) // gcd(lcd, arr[i])
    return lcd