T = int(input())
 
for i in range(1, T + 1):
    input1 = int(input())
 
    arr1 = []
 
    for j in range(input1):
        temp = []
        for k in range(j+1):
            if k == 0 or k == j:
                temp.append(1)
            else:
                temp.append(arr1[j-1][k-1] + arr1[j-1][k])
        arr1.append(temp)
    print(arr12)
 
    print("#{}".format(i))
    for x in range(input1):
        for y in range(x+1):
            print(arr1[x][y], end=' ')
 
        print()