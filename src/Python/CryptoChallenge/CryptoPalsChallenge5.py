import binascii


def decipherAnswerAndSendItBack(answer, key):
    unhex_answer = binascii.unhexlify(answer)

    x = 0
    result = bytearray()
    for i in range(len(unhex_answer)):
        result.append(unhex_answer[i] ^ key[x])
        if x < 2:
            x += 1
        else:
            x = 0
    res = result.decode()

    return res


def main():
    s = "Burning 'em, if you ain't quick and nimble I go crazy when I hear a cymbal".encode()

    # s = "Burning \'em, if you ain\'t quick and nimble\nI go crazy when I hear a cymbal".encode() <--- # rätta svaret!
    # tog det baklänges

    key = "ICE".encode()

    answer = "0b3637272a2b2e63622c2e69692a23693a2a3c6324202d623d63343c2a26226324272765272" \
             "a282b2f20430a652e2c652a3124333a653e2b2027630c692b20283165286326302e27282f"

    x = 0
    result = bytearray()
    for i in range(len(s)):
        result.append(s[i] ^ key[x])
        if x < 2:
            x += 1
        else:
            x = 0

    my_answer = binascii.hexlify(result).decode()
    print(my_answer)
    print(answer)
    if my_answer == answer:
        print("Yayyy, svaren är lika")
    else:
        print("Svaret stämmer inte :(")

    answer_in_plain_text = decipherAnswerAndSendItBack(answer, key)
    print("----------------------------")
    print("Svaret i ren text:")
    print(answer_in_plain_text)


if __name__ == '__main__':
    main()
