T = int(input())
for o in range(T):
    N = int(input())
    p_list = []
    m_list = []
    N_list = list(map(int,input().split()))
    for i in range(N):
        if N_list[i] >0:
            p_list.append(N_list[i])
        else:
            m_list.append(N_list[i])
    for i in range(len(m_list)):
        m_list[i] = -m_list[i]
    h_list = m_list + p_list
    res = min(h_list)
    cou = h_list.count(res)

    print("#{0} {1} {2}".format(o+1,res,cou))


