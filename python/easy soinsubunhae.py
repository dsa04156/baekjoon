T = int(input())
cnt = 0
for i in range(T):
    k = int(input())
    two = three = five = seven = eleven = 0
    while k%2 == 0:
        k = k/2
        two += 1
    while k%3 == 0:
        k = k/3
        three += 1
    while k%5==0:
        k /= 5
        five += 1
    while k%7 ==0:
        k /=7
        seven += 1
    while k%11 ==0:
        k /= 11
        eleven +=1

    cnt += 1
    print("#%d"%cnt,two,three,five,seven,eleven)
