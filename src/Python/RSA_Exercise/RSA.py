import base64
import math
import os
import sys

from RSA_Exercise import KeyPair


class RSA:
    public_key = ''
    private_key = ''

    def __init__(self, name):
        self.name = name


def bytes2int(byte_data):
    return int.from_bytes(byte_data, 'big', signed=False)


def int2bytes(number: int, fill_size: int = 0) -> bytes:
    """
    Convert an unsigned integer to bytes (big-endian)::
    Does not preserve leading zeros if you don't specify a fill size.
    :param number:
        Integer value
    :param fill_size:
        If the optional fill size is given the length of the resulting
        byte string is expected to be the fill size and will be padded
        with prefix zero bytes to satisfy that length.
    :returns:
        Raw bytes (base-256 representation).
    :raises:
        ``OverflowError`` when fill_size is given and the number takes up more
        bytes than fit into the block. This requires the ``overflow``
        argument to this function to be set to ``False`` otherwise, no
        error will be raised.
    """

    if number < 0:
        raise ValueError("Number must be an unsigned integer: %d" % number)

    bytes_required = max(1, math.ceil(number.bit_length() / 8))

    if fill_size > 0:
        return number.to_bytes(fill_size, 'big')

    return number.to_bytes(bytes_required, 'big')


def encrypt(key_name, message):
    __readKey(key_name)
    _, e, n = RSA.public_key
    byte_msg = message.encode(encoding='utf-8')
    int_message = bytes2int(byte_msg)
    return base64.b64encode(int2bytes(pow(int_message, e, n))).decode()


def encrypt_To_File(key_name, message):
    encoded_msg = encrypt(key_name, message)
    i = 0

    if os.path.exists(f'Messages/{key_name}_enc_' + str(i)):
        while os.path.exists(f'Messages/{key_name}_enc_' + str(i)):
            i += 1

    with open(f'Messages/{key_name}_enc_' + str(i), 'w') as f:
        f.write(str(encoded_msg))

    print("Messages/" + key_name + "_enc_" + str(i) + " created in : Messages")


def decrypt(key_name, message):
    __readKey(key_name)
    _, d, n = RSA.private_key
    message1 = base64.b64decode(message)
    int_message = bytes2int(message1)
    result = pow(int_message, d, n)
    bytes_result = int2bytes(result)
    return bytes_result.decode('utf-8')


def decrypt_from_file(key_name, file_name):
    encoded_msg = open('Messages/' + file_name).read()
    return decrypt(key_name, encoded_msg)


def __readKey(key_name):
    if not os.path.exists(f'Keys/{key_name}_pub.key') or not os.path.exists(f'Keys/{key_name}_priv.key'):
        sys.exit(
            f'WARNING: The file name Keys/{key_name}_pub.key or Keys/{key_name}_priv.key does not exists!'
        )

    RSA.public_key = [int(value) for value in open(f'Keys/{key_name}_pub.key').read().split(',')]
    RSA.private_key = [int(value) for value in open(f'Keys/{key_name}_priv.key').read().split(',')]


def generate_new_key(key_name, key_size=2048):
    KeyPair.generate_keys(key_name, key_size)
