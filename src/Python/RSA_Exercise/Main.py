import RSA


def generate_keys():
    key_name = input('Enter key name:')
    RSA.generate_new_key(key_name)


def encrypt_message_to_string():
    key_name = input('Enter key: ')
    message = input('Enter message to encrypt: ')
    encrypted_msg = RSA.encrypt(key_name, message)
    print(encrypted_msg)


def encrypt_message_to_file():
    key_name = input('Enter key: ')
    message = input('Enter message to encrypt: ')
    RSA.encrypt_To_File(key_name, message)


def decrypt_message_from_string():
    key_name = input('Enter key: ')
    message = input('Enter message to encrypt: ')
    decrypted_msg = RSA.decrypt(key_name, message)
    print(decrypted_msg)


def decrypt_message_from_file():
    key_name = input('Enter key: ')
    file_name = input('Enter file name to decrypt: ')
    print(RSA.decrypt_from_file(key_name, file_name))


def menu():
    while True:
        print('>>>>> ENCRYPTION MENU <<<<<')
        print('===========================')
        print('1. Generate keys')
        print('2. Encrypt: Message -> string')
        print('3. Encrypt: Message -> file')
        print('4. Decrypt: Message -> String')
        print('5. Decrypt: File -> String')
        print('9. Exit')
        choice = input('> ')

        if choice == '1':
            generate_keys()
        elif choice == '2':
            encrypt_message_to_string()
        elif choice == '3':
            encrypt_message_to_file()
        elif choice == '4':
            decrypt_message_from_string()
        elif choice == '5':
            decrypt_message_from_file()
        elif choice == '9':
            break


def main():
    menu()


if __name__ == '__main__':
    main()
