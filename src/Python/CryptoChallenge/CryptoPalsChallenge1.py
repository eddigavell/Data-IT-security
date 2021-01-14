import binascii
import base64


def main():
    s = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
    print(binascii.unhexlify(s).decode())  # tar s och avhexar till vanlig string (decode bara för att gå från byte till string)

    result = base64.b64encode(binascii.unhexlify(s)).decode()
    print(result)
    rightresult = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"

    if result == rightresult:
        print('Yay, det är rätt')
    else:
        print('Något blev fel')
        print('Ditt svar ', result)
        print("Rätt svar: ", rightresult)


if __name__ == '__main__':
    main()
