import RSA


def generate_keys():
    key_name = input('Enter key name:')
    RSA.generate_new_key(key_name)


def encrypt_message_to_string():
    is_it_sign = input('Is it for signature? (yes/what ever): ')
    key_name = input('Enter key: ')
    message = input('Enter message to encrypt: ')
    if is_it_sign == 'yes':
        encrypted_msg = RSA.encrypt(key_name, message, 'sign')
    else:
        encrypted_msg = RSA.encrypt(key_name, message)
    print(encrypted_msg)


def encrypt_message_to_binary():
    # Takes message and encrypts it, after encryption converts it to binary
    key_name = input('Enter key: ')
    message = input('Please enter message to encrypt: ')
    encrypted_message = RSA.encrypt(key_name, message)
    binary = ''.join('{:08b}'.format(ord(c)) for c in encrypted_message)
    print(f'Converted to binary: {binary}')


def encrypt_message_to_file():
    key_name = input('Enter key: ')
    message = input('Enter message to encrypt: ')
    RSA.encrypt_To_File(key_name, message)


def decrypt_message_from_string():
    is_it_sign = input('Is it for signature? (yes/what ever): ')
    key_name = input('Enter key: ')
    message = input('Enter message to encrypt: ')
    if is_it_sign == 'yes':
        decrypted_msg = RSA.decrypt(key_name, message, 'sign')
    else:
        decrypted_msg = RSA.decrypt(key_name, message)
    print(decrypted_msg)


def decrypt_message_from_binary():
    # takes binary -> ascii string -> decrypt -> string
    def returnDecimalStringFromBinary(s):
        size_s = len(s)
        result = ''
        if size_s % 8 == 0:
            x = 0
            temp = ''
            for i in range(size_s):
                temp += s[i]
                x += 1
                if x == 8:
                    x = 0
                    result += chr(int(temp, 2))
                    temp = ''
        else:
            print('The message is not correct bytes. (message_size % 8 != 0) when it should be (message_size % 8 == 0)')
        return result

    key_name = input('Enter key: ')
    binary = input('Please enter message to encrypt: ')
    encrypted_msg = returnDecimalStringFromBinary(binary)
    decrypted_message = RSA.decrypt(key_name, encrypted_msg)
    print(decrypted_message)


def decrypt_message_from_file():
    key_name = input('Enter key: ')
    file_name = input('Enter file name to decrypt: ')
    print(RSA.decrypt_from_file(key_name, file_name))


def menu():
    while True:
        print('>>>>> ENCRYPTION MENU <<<<<')
        print('===========================')
        print('1. Generate keys')
        print('2. Encrypt: Message -> string (Normal / signature)')
        print('3. Encrypt: Message -> Binary')
        print('4. Encrypt: Message -> file')
        print('5. Decrypt: Message -> String (Normal / signature)')
        print('6. Decrypt: Binary -> String ')
        print('7. Decrypt: File -> String')
        print('9. Exit')
        choice = input('> ')

        if choice == '1':
            generate_keys()
        elif choice == '2':
            encrypt_message_to_string()
        elif choice == '3':
            encrypt_message_to_binary()
        elif choice == '4':
            encrypt_message_to_file()
        elif choice == '5':
            decrypt_message_from_string()
        elif choice == '6':
            decrypt_message_from_binary()
        elif choice == '7':
            decrypt_message_from_file()
        elif choice == '9':
            break
        else:
            continue


def main():
    menu()


if __name__ == '__main__':
    main()
