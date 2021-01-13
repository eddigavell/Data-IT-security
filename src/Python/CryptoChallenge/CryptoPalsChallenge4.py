import string


def main():
    # One of the 60-character strings in this file has been encrypted by single-character XOR.
    # Find it.
    # (Your code from #3 should help.)
    message = open('Challenge4.txt').readlines()
    key = bytearray()
    result = bytearray()

    for i in range(60):
        key += 'X'.encode()

    for i in range(len(message)):
        result.append(message[i] ^ key[i])
    print(result.decode())

    print("INTE LÖST :O")

if __name__ == '__main__':
    main()
