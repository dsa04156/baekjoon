import sys
num = int(sys.stdin.readline().strip())
count = 0
stack = []
result = []


for i in range(num):
    x = int(sys.stdin.readline().strip())

    while count < x:
        count += 1
        stack.append(count)
        result.append("+")

    if stack[-1] == x:
        stack.pop()
        result.append("-")

    else:
        print("No")
        exit(0)


print("\n".join(result))


# n = int(input())

# count = 1
# stack = []
# result = []

# for _ in range(n):
#     data = int(input())

#     while count <= data:
#         stack.append(count)
#         result.append('+')
#         count += 1

#     if stack.pop() == data:
#         result.append('-')

#     else:
#         print("NO")
#         exit(0)

# print("\n".join(result))