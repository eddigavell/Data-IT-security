import binascii

def main():
    # One of the 60-character strings in this file has been encrypted by single-character XOR.
    # Find it.
    # (Your code from #3 should help.)

    message = open('Challenge4.txt').readlines()  # Open and read file

    fisk = ''

    for i in range(len(message)):
        fisk[i] = message[i].strip()


    print(fisk[1], ':', len(fisk[1]))

    print(binascii.unhexlify(fisk[1]))


if __name__ == '__main__':
    main()
