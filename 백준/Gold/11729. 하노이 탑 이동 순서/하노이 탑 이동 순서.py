# 11729
n = int(input())

def recursion(n, a, b, c):
    if n == 1:
        print(a, c)
    else:
        recursion(n-1, a, c, b)
        print(a, c)
        recursion(n-1, b, a, c)
sum = 2 ** n - 1
print(sum)

recursion(n, 1, 2, 3)