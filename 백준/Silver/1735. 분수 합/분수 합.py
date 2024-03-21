arr = []
for _ in range(2):
    x, y = map(int, input().split())
    arr.append((x, y))

def lcm(a, b):
    min_data = min(a,b)
    result = 1
    for i in range(min_data, 0, -1):
        if a % i == 0 and b % i == 0:
            result *= i
            a //= i
            b //= i
    result *= (a*b)
    return result

def gcd(a, b):
    min_data = min(a,b)
    result = 1
    for i in range(min_data, 0, -1):
        if a % i == 0 and b % i == 0:
            result = i
            break
    return result


lcm_data = lcm(arr[0][1], arr[1][1])
sum_deno = 0

for x, y in arr:
    num = lcm_data // y
    x *= num
    sum_deno += x

gcd_calculator = gcd(sum_deno, lcm_data)
if gcd_calculator != 1:
    print(sum_deno//gcd_calculator, lcm_data//gcd_calculator)
else: print(sum_deno, lcm_data)
