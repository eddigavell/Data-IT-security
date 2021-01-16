def instructions():
    instruction = ''
    # Let KEYSIZE be the guessed length of the key; try values from 2 to (say) 40.
    # Write a function to compute the edit distance/Hamming distance between two strings.

    # The Hamming distance is just the number of differing bits. The distance between:
    # "this is a test" and "wokka wokka!!!" is 37. Make sure your code agrees before you proceed.

    # For each KEYSIZE, take the first KEYSIZE worth of bytes, and the second KEYSIZE worth of bytes,
    # and find the edit distance between them. Normalize this result by dividing by KEYSIZE.

    # The KEYSIZE with the smallest normalized edit distance is probably the key.
    # You could proceed perhaps with the smallest 2-3 KEYSIZE values.
    # Or take 4 KEYSIZE blocks instead of 2 and average the distances.

    # Now that you probably know the KEYSIZE: break the ciphertext into blocks of KEYSIZE length.

    # Now transpose the blocks: make a block that is the first byte of every block,
    # and a block that is the second byte of every block, and so on.

    # Solve each block as if it was single-character XOR. You already have code to do this.
    # For each block, the single-byte XOR key that produces the best looking histogram
    # is the repeating-key XOR key byte for that block. Put them together and you have the key.


def main():
    s1 = "this is a test"
    s2 = "wokka wokka!!!"
    key_answer = 37
    keysize = 2


if __name__ == '__main__':
    main()
