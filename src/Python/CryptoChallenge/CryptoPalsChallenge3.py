import binascii


def main():
    hexencodedstring = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736"
    # ... has been XOR'd against a single character. Find the key, decrypt the message.
    # You can do this by hand. But don't: write code to do it for you.
    # How? Devise some method for "scoring" a piece of English plaintext. Character frequency is a good metric.
    # Evaluate each output and choose the one with the best score.
    dehexencodedstring = binascii.unhexlify(hexencodedstring)

    decodestring = bytearray()
    for i in range(34):
        decodestring += 'X'.encode()
    print(decodestring)
    result = bytearray()
    for i in range(len(dehexencodedstring)):
        result.append(dehexencodedstring[i] ^ decodestring[i])
    print(result.decode())


    # Omvänd ordning
    teststring = result
    print(teststring)

    test = bytearray()
    for i in range(len(teststring)):
        test.append(teststring[i] ^ decodestring[i])
    print(binascii.hexlify(test))


if __name__ == '__main__':
    main()
