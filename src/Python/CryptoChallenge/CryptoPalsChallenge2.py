import binascii


def main():
    feedstring = "1c0111001f010100061a024b53535009181c"

    feedstringdehex = binascii.unhexlify(feedstring)

    #after hex decoding and when XOR'd against:
    xorstring = "686974207468652062756c6c277320657965"
    xorstringdehex = binascii.unhexlify(xorstring)

    result = bytearray()
    for i in range(len(feedstringdehex)):
        result.append(feedstringdehex[i] ^ xorstringdehex[i])
    print(result.decode())

    hexedresult = binascii.hexlify(result).decode()

    #should produce
    rightresult = "746865206b696420646f6e277420706c6179"

    if hexedresult == rightresult:
        print("YAY")
    else:
        print(hexedresult)
        print(rightresult)


if __name__ == '__main__':
    main()
