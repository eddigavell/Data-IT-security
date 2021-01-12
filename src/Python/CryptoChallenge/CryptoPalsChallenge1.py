import binascii
import base64


def main():
    s = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d"
    print(binascii.unhexlify(s))  # tar s och avhexar till vanlig string (fortfarande i byte)

    print(base64.b64encode(binascii.unhexlify(s)))  # Avhexad s -> base64 på det avhexade (fortfarande i byte)

    result = base64.b64encode(binascii.unhexlify(s)).decode()
    rightresult = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t"

    if result == rightresult:
        print("Det är rätt")
    else:
        print("något blev fel")


if __name__ == '__main__':
    main()
