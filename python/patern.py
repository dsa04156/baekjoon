T = int(input())
for j in range(T):
    w = list(map(str,input()))
    i=1
    while w[0] != w[i] or w[1] != w[i+1]:
        i += 1
    print("#{0} {1}".format(j+1,i))

# T = int(input())
#
# for t in range(T):
#     inputStr = list(input())
#     for i in range(len(inputStr)):
#         if inputStr[0:i + 1] == inputStr[i + 1:(i + 1) * 2]:
#             print('#%d %d' % (t + 1, i + 1))
#             break

