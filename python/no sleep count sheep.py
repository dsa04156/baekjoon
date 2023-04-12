T = int(input())
x = 1
for i in range(T):
    N = int(input())
    N_set = set(map(int, str(N)))
    cnt = 1

    while len(N_set) != 10:
        a = N * cnt
        a_set = set(map(int, str(a)))
        N_set = (N_set | a_set)
        cnt += 1
    print("#{0} {1}".format(x,a))
    x += 1
