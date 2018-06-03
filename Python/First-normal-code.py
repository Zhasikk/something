def write(number):
    zero = ["  0", " 0 0", "0   0"," 0 0", "  0"]
    one = ["  1", "1 1", "  1", "  1","  1", "1 1 1"]
    two = ["2 2 2", "    2", "    2", "    2","2 2 2","2    ","2    ","2    ","2 2 2"]
    three = ["3 3 3", "    3", "    3", "    3", "3 3 3", "    3", "    3", "    3", "3 3 3"]
    digits = [zero, one, two, three]
    sum=0
    while True:
        line=digits[number]
        print(line[sum])
        if sum == len(line)-1:
            print("end")
            break
        sum += 1
write(0)