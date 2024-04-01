tc = int(input())

for _ in range(tc):
    cl_type = dict()
    n = int(input())
    for _ in range(n):
        name, cloth = map(str, input().split())
        if cloth in cl_type: 
            cl_type[cloth].append(name)
        else: cl_type[cloth] = [name]
    result = 1
    for key in cl_type.keys():
        result *= len(cl_type[key]) + 1
    print(result-1)