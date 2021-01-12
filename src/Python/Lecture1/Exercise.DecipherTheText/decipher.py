from collections import Counter


def wordcount():
    message = open('TextToDecipher.txt').read()
    count = Counter(message)
    words = message.split()
    words = [word.replace(',', '') for word in words]
    words = [word.replace('.', '') for word in words]
    word_count = Counter(words)
    #one_letter_words = [word for word in words if len(word) == 1]
    #two_letter_words = [word for word in words if len(word) == 2]
    #three_letter_words = [word for word in words if len(word) == 3]
    print(count)
    print(word_count)
    #print(one_letter_words)
    #print(two_letter_words)
    #print(three_letter_words)


def main():
    wordcount()
    print()
    message = open('TextToDecipher.txt').read()
    keys = []
    values = []
    keys = dict(zip(keys, values))
    #ABCDEFGHIJKLMNOPQRSTUVWXYZ
    keys.update({'A': 'Y'})
    keys.update({'B': 'P'})
    keys.update({'C': 'B'})
    keys.update({'D': 'G'})
    keys.update({'E': 'I'})
    keys.update({'F': 'A'})
    keys.update({'G': 'D'})
    keys.update({'H': 'V'})
    keys.update({'I': 'S'})
    keys.update({'J': 'N'})
    keys.update({'K': 'L'})
    keys.update({'L': 'J'})
    keys.update({'M': 'C'})
    keys.update({'N': 'E'})
    keys.update({'O': 'F'})
    keys.update({'P': 'U'})
    keys.update({'Q': 'R'})
    keys.update({'R': 'Z'})
    keys.update({'S': 'K'})
    keys.update({'T': 'O'})
    keys.update({'U': 'T'})
    keys.update({'V': 'X'})
    keys.update({'W': 'Q'})
    keys.update({'X': 'W'})
    keys.update({'Y': 'H'})
    keys.update({'Z': 'M'})

    for letter in message:
        if letter.upper() in keys:
            print(keys[letter.upper()], end='')
        else:
            print(letter, end='')
    print()


if __name__ == '__main__':
    main()