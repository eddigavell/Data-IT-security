import os
import sys

from RSA_Exercise import KeyPair


class RSA:
    public_key = ''
    private_key = ''

    def __init__(self, name):
        self.name = name


def encrypt(key_name, message):
    __readKey(key_name)
    byte_msg = message.encode()
    _, e, n = RSA.public_key
    return [pow(c, e, n) for c in byte_msg]


def encrypt_To_File(key_name, message):
    __readKey(key_name)
    byte_msg = message.encode()
    key_size, e, n = RSA.public_key
    encoded_msg = [pow(c, e, n) for c in byte_msg]
    i = 0
    if os.path.exists(f'Messages/{key_name}_encrypted_msg_' + str(i)):
        while os.path.exists(f'Messages/{key_name}_encrypted_msg_' + str(i)):
            i += 1
    with open(f'Messages/{key_name}_encrypted_msg_' + str(i), 'w') as f:
        f.write(str(encoded_msg))
    print("Messages/" + key_name + "_encrypted_msg_" + str(i) + " created in : Messages")


def decrypt(key_name, message):
    __readKey(key_name)
    _, d, n = RSA.private_key
    return ''.join([chr(pow(c, d, n)) for c in message])


def decrypt_from_file(key_name, file_name):
    __readKey(key_name)
    _, d, n = RSA.private_key
    message = open('Messages/' + file_name).readlines()  # Open and read file
    msg = ''
    for i in message:
        msg += i
    print(msg)

    return ''.join([chr(pow(c, d, n)) for c in msg.encode()])


def __readKey(key_name):
    if not os.path.exists(f'Keys/{key_name}_pub.key') or not os.path.exists(f'Keys/{key_name}_priv.key'):
        sys.exit(
            f'WARNING: The file name Keys/{key_name}_pub.key or Keys/{key_name}_priv.key does not exists!'
        )

    RSA.public_key = [int(value) for value in open(f'Keys/{key_name}_pub.key').read().split(',')]
    RSA.private_key = [int(value) for value in open(f'Keys/{key_name}_priv.key').read().split(',')]


def generate_new_key(key_name, key_size=2048):
    KeyPair.generate_keys(key_name, key_size)
