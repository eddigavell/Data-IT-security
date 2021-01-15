import binascii


def processStringsAndPrintAnswer(feed_string):
    encoded_feed_string = feed_string.encode()
    for i in range(33, 90):
        x = str(chr(i)).encode()
        result = bytearray()
        for j in range(len(encoded_feed_string)):
            result.append(encoded_feed_string[j] ^ x[0])
        decoded_result = result.decode("iso-8859-15")

        o = decoded_result.replace(" ", "").strip()

        if o.isalpha():
            print(decoded_result)
            print('Key:', x.decode())


def instructions():
    jujedamig = ''
    # One of the 60-character strings in this file has been encrypted by single-character XOR.
    # Find it.
    # (Your code from #3 should help.)


def main():
    message = open('Challenge4.txt').readlines()  # Open and read file

    feed_strings = []  # Empty list

    for i in range(len(message)):
        feed_strings.append(message[i].strip())  # Adds each message to its own list place

    for string in feed_strings:
        dehex_feed_string_in_byte = binascii.unhexlify(string)
        decoded_dehex_feedstring = dehex_feed_string_in_byte.decode("iso-8859-15") #unicode error, försök till att lösa
        processStringsAndPrintAnswer(decoded_dehex_feedstring)


if __name__ == '__main__':
    main()
