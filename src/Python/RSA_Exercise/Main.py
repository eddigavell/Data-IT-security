import RSA


def main():
    # RSA.encrypt_To_File("Shayan", "H")
    # decrypted_msg = RSA.decrypt_from_file("Shayan", "Shayan_encrypted_msg_2")
    # print(decrypted_msg)
    encoded = RSA.encrypt("Shayan", "H")
    print(encoded)
    print(RSA.decrypt("Shayan", encoded))

    RSA.decrypt_from_file("Shayan", "Shayan_encrypted_msg_2")


if __name__ == '__main__':
    main()
