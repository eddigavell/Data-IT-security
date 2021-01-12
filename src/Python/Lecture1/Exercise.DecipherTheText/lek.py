import string
import random


def main():
    message = open('TextToDecipher.txt').read()
    keys = [character for character in string.ascii_uppercase]
    values = [character for character in string.ascii_uppercase]
    random.shuffle(values)
    keys = dict(zip(keys, values))
    keys.update({'Z': 'T'})
    keys.update({'Q': 'O'})
    keys.update({'T': 'I'})
    keys.update({'J': 'S'})
    keys.update({'F': 'A'})
    print(keys)
    #Z = T
    #Q = O
    #T = I
    #J = S
    #F = A

    #ABCDEFGHIJKLMNOPQRSTUVWXYZ

    #TO. QFCCEU IFU IS YEI OQTJU BTQMY QTMSEJD, NFUEJD A DQNFU CED MFQQTU,
    #FJG KTTSEJD.

    #ZQ. QFCCEU IFU TJ YEI OQTJU BTQMY QTMSEJD, NFUEJD F DQNFU CED MFQQTU,
    #FJG KTTSEJD.



    for letter in message:
        if letter.upper() in keys:
            print(keys[letter.upper()], end='')
        else:
            print(letter, end='')
    print()








if __name__ == '__main__':
    main()