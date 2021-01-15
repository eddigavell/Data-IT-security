import binascii


def test1():
    test_string = 'Now that the party is jumping'
    o = test_string.replace(" ", "")
    score = 0

    if o.isalpha():
        print('isalpha: ', o)
    else:
        print('isalpha: nope')

    if test_string.isalpha():
        print('test: ', test_string)
    else:
        print('test: nope')

def main():
    test1()


if __name__ == '__main__':
    main()
