N = int(input())

def sol(m):
    if m==1:
        return ['***','* *', '***']
    
    arr = star(1//3)
    stars = []
    for i in arr:
        stars.append(i*3)
    for i in arr:
        stars.append(i+' '*(m//3)+i)
    for i in arr:
        stars.append(i*3)
