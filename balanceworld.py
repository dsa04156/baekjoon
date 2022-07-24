while True:
    a = input()
    stk = []
    if a== "." :
        break

    for i in a:
        if i == '[' or i =='(':
            stk.append(i)
        elif i == ']':
            if len(stk) != 0 and stk[-1] == '[':
                stk.pop()
            else:
                stk.append(']')
                break
        elif i == ')':
            if len(stk) != 0 and stk[-1] == '(':
                stk.pop()
            else:
                stk.append(')')
                break

    if len(stk) == 0:
        print('yes')
    else:
        print('no')